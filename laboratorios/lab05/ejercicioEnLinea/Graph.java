package Laboratorio5_2;


// Java program to print DFS traversal from a given given graph

import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[], int b[], int color) {

        // Mark the current node as visited and print it
        visited[v] = true;
        b[v]=color;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited, b, color);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        boolean a = true;
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        int b[] = new int[V];
        DFSUtil(v, visited, b, 1);
        for (int i = 0; i < visited.length - 1; i++) {
            if (b[i] == b[i + 1]) a = false;
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.toString(b));
        System.out.println(a);
    }
}
// This code is contributed by Aakash Hasija
