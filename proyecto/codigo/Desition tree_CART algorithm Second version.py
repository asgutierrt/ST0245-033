
# coding: utf-8

# In[1]:


import pandas as pd
import matplotlib.pyplot as plt
from random import randint


# In[ ]:


# to open file
def read_file(fileName):
    """Reads the information contain in a dataset"""
    archivo = pd.read_csv(fileName, delimiter=',')
    w, h = len(archivo.columns), len(archivo);
    data = [[0 for x in range(w)] for y in range(h)]
    a=0
    for col in archivo:
        b=0
        for row in archivo[col]:
            data[b][a] = row
            b+=1
        a+=1
    header= []
    for line in archivo:
        header.append(line)
    return data, header
    
#O(n^2)


# In[ ]:


# check format and put data
data, header=read_file('data_training.txt')
training_data = data


# In[ ]:


def unique_vals(rows, col):
    """Find the unique values for a column in a dataset."""
    return set([row[col] for row in rows])

#O(n)


# In[ ]:


def class_counts(rows):
    """Counts the number of each type of example in a dataset."""
    counts = {}  # a dictionary of label -> count.
    for row in rows:
        # in our dataset format, the label is always the last column
        label = row[-1]
        if label not in counts:
            counts[label] = 0
        counts[label] += 1
    return counts

#O(n)


# In[ ]:


def is_numeric(value):
    """Test if a value is numeric."""
    return isinstance(value, int) or isinstance(value, float)

#O(1)


# In[ ]:


class Question:
    """A Question is used to partition a dataset.

    This class just records a 'column number' (e.g., 0 for Color) and a
    'column value' (e.g., Green). The 'match' method is used to compare
    the feature value in an example to the feature value stored in the
    question. See the demo below.
    """

    def __init__(self, column, value):
        self.column = column
        self.value = value

    def match(self, example):
        # Compare the feature value in an example to the
        # feature value in this question.
        val = example[self.column]
        if is_numeric(val):
            return val >= self.value
        else:
            return val == self.value

    def __repr__(self):
        # This is just a helper method to print
        # the question in a readable format.
        condition = "=="
        if is_numeric(self.value):
            condition = ">="
        return "Is %s %s %s?" % (
            header[self.column], condition, str(self.value))
    
    
#O(1)


# In[ ]:


def partition(rows, question):
    """Partitions a dataset.

    For each row in the dataset, check if it matches the question. If
    so, add it to 'true rows', otherwise, add it to 'false rows'.
    """
    true_rows, false_rows = [], []
    for row in rows:
        if question.match(row):
            true_rows.append(row)
        else:
            false_rows.append(row)
    return true_rows, false_rows

#O(n)


# In[ ]:


def gini(rows):
    """Calculate the Gini Impurity for a list of rows.

    There are a few different ways to do this, I thought this one was
    the most concise. See:
    https://en.wikipedia.org/wiki/Decision_tree_learning#Gini_impurity
    """
    counts = class_counts(rows)
    impurity = 1
    for lbl in counts:
        prob_of_lbl = counts[lbl] / float(len(rows))
        impurity -= prob_of_lbl**2
    return impurity

#O(n)


# In[ ]:


def info_gain(left, right, current_uncertainty):
    """Information Gain.

    The uncertainty of the starting node, minus the weighted impurity of
    two child nodes.
    """
    p = float(len(left)) / (len(left) + len(right))
    return current_uncertainty - p * gini(left) - (1 - p) * gini(right)

#O(n)


# In[ ]:


def find_best_split(rows):
    """Find the best question to ask by iterating over every feature / value
    and calculating the information gain."""
    best_gain = 0  # keep track of the best information gain
    best_question = None  # keep train of the feature / value that produced it
    current_uncertainty = gini(rows)
    n_features = len(rows[0]) - 1  # number of columns

    for col in range(n_features):  # for each feature

        values = set([row[col] for row in rows])  # unique values in the column

        for val in values:  # for each value

            question = Question(col, val)

            # try splitting the dataset
            true_rows, false_rows = partition(rows, question)

            # Skip this split if it doesn't divide the
            # dataset.
            if len(true_rows) == 0 or len(false_rows) == 0:
                continue

            # Calculate the information gain from this split
            gain = info_gain(true_rows, false_rows, current_uncertainty)

            # You actually can use '>' instead of '>=' here
            # but I wanted the tree to look a certain way for our
            # toy dataset.
            if gain >= best_gain:
                best_gain, best_question = gain, question

    return best_gain, best_question

#O(n^2)


# In[ ]:


class Leaf:
    """A Leaf node classifies data.

    This holds a dictionary of class (e.g., "Apple") -> number of times
    it appears in the rows from the training data that reach this leaf.
    """

    def __init__(self, rows):
        self.rows=rows
        self.predictions = class_counts(rows)
        
    def add_leaf (self, row):
        self.rows.append(row)
        if len(self.rows)==0:
            self.rows=row
            self.predictions = class_counts(row)
        else:
            self.predictions = class_counts(self.rows)


# In[ ]:


class Decision_Node:
    """A Decision Node asks a question.

    This holds a reference to the question, and to the two child nodes.
    """

    def __init__(self,
                 question,
                 true_branch,
                 false_branch):
        self.question = question
        self.true_branch = true_branch
        self.false_branch = false_branch
        
    def add_leaf (self, row):
        if self.question.match(row):
            self.true_branch.add_leaf(row)
        else:
            self.false_branch.add_leaf(row)
        
        


# In[ ]:


def build_tree(rows):
    """Builds the tree.

    Rules of recursion: 1) Believe that it works. 2) Start by checking
    for the base case (no further information gain). 3) Prepare for
    giant stack traces.
    """

    # Try partitioing the dataset on each of the unique attribute,
    # calculate the information gain,
    # and return the question that produces the highest gain.
    gain, question = find_best_split(rows)
    
    # Base case: no further info gain
    # Since we can ask no further questions,
    # we'll return a leaf.
    if gain == 0:
        return Leaf(rows) 

    # If we reach here, we have found a useful feature / value
    # to partition on.
    true_rows, false_rows = partition(rows, question)

    # Recursively build the true branch.
    true_branch = build_tree(true_rows)

    # Recursively build the false branch.
    false_branch = build_tree(false_rows)

    # Return a Question node.
    # This records the best feature / value to ask at this point,
    # as well as the branches to follow
    # dependingo on the answer.
    return Decision_Node(question, true_branch, false_branch)

#O(n^2)


# In[ ]:


def print_tree(node, spacing=""):
    """World's most elegant tree printing function."""

    # Base case: we've reached a leaf
    if isinstance(node, Leaf):
        print (spacing + "Predict", node.predictions)
        return

    # Print the question at this node
    print (spacing + str(node.question))

    # Call this function recursively on the true branch
    print (spacing + '--> True:')
    print_tree(node.true_branch, spacing + "  ")

    # Call this function recursively on the false branch
    print (spacing + '--> False:')
    print_tree(node.false_branch, spacing + "  ")
    


# In[ ]:


def list_questions(node, questions):
    
    """to create a list of the asked questions"""

    # Base case: we've reached a leaf
    if isinstance(node, Leaf):
        questions.append("Leaf")
        return 

    # add the question at this node to the list
    questions.append(node.question)
    
    # Call this function recursively on the true branch
    list_questions(node.true_branch,questions)

    # Call this function recursively on the false branch
    list_questions(node.false_branch, questions)
    


# In[ ]:


my_tree= build_tree(training_data)
questions=[]
list_questions(my_tree,questions)
#print(questions)


# In[ ]:


# time complexity analysis

import time
data_sets = ['data_training.txt', "data_set3.txt", "data_set2.txt", "data_set1.txt"]
for names in data_sets:
    # read file
    start_time=time.time()
    data, header=read_file(names)
    print("read file")
    print ("-- %s Seconds--" % (time.time()-start_time))
    
    # build tree
    start_time=time.time()
    my_tree= build_tree(data)
    print("build tree")
    print ("-- %s Seconds--" % (time.time()-start_time))
    
    # print tree
    start_time=time.time()
    print_tree(my_tree)
    print("print tree")
    print ("-- %s Seconds--" % (time.time()-start_time))


# In[ ]:


def classify(row, node):
    """See the 'rules of recursion' above."""

    # Base case: we've reached a leaf
    if isinstance(node, Leaf):
        return node.predictions

    # Decide whether to follow the true-branch or the false-branch.
    # Compare the feature / value stored in the node,
    # to the example we're considering.
    if node.question.match(row):
        return classify(row, node.true_branch)
    else:
        return classify(row, node.false_branch)


# In[ ]:


def print_leaf(counts):
    """A nicer way to print the predictions at a leaf."""
    total = sum(counts.values()) * 1.0
    probs = {}
    for lbl in counts.keys():
        probs[lbl] = str(int(counts[lbl] / total * 100)) + "%"
    return probs


# In[ ]:


# Evaluate
testing_data = data


# In[ ]:


for row in testing_data:
    print ("Actual: %s. Predicted: %s" %
           (row[-1], print_leaf(classify(row, my_tree))))


# In[ ]:


# To predict the label by generating a list of questions with half the test data and then using it to clasify the entire set.
# At the end compare the predicted labels with the true ones

# a. builds tree with the given set of data 
def test (test_data):
    my_tree= build_tree(test_data)
    questions = print_tree(my_tree)
    
# b. chooses a portion of the data in the set randomly
def choose_data (test_data, portion):
    total_len = len(test_data)
    training_len = total_len/portion
    
    training_data=[]
    while (len(training_data)<=training_len):
        index = randint(0, total_len-1)
        line = test_data[index]
        training_data.append(line)
    return training_data  


# In[ ]:


#this method builds a base tree with half the data in the set and uses it to classify the rest of the data

data, header=read_file('data_training.txt')
test_data = data
training_data = choose_data(test_data, 2)
base_tree = build_tree(training_data)

for row in test_data:
    base_tree.add_leaf(row)

for row in testing_data:
    print ("Actual: %s. Predicted: %s" %
           (row[-1], print_leaf(classify(row, base_tree))))
