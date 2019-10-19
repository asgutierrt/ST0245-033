package Taller12;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//GRAFO CON LISTAS
public class DigraphAL extends Graph {
    private ArrayList<LinkedList<Pair<Integer, Integer>>> nodo;

    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>());
        }
    }

    public void addArc(int source, int destination, int weight) {
        nodo.get(source).add(new Pair<>(destination, weight));
    }

    public int getWeight(int source, int destination) {
        int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.getKey() == destination) result = integerIntegerPair.getValue();
        }
        return result;
    }

    @Override
    public void fillGraph(DigraphAM gMatrix) {

    }

    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> n = new ArrayList<>();

        nodo.get(vertice).forEach(i -> n.add(i.getKey()));

        return n;
    }

    /**
     *
     * Code adapted from Java2Blog
     * Available: https://java2blog.com/breadth-first-search-in-java/
     *
     * @param initialNode
     * @param finalNode
     * @return true if two nodes are connected
     */
    public boolean bfs(int initialNode, int finalNode) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[nodo.size()];
        boolean[] marked = new boolean[nodo.size()]; //Marca para ver si se paso por un nodo
        int current, next;
        queue.add(initialNode);
        distance[initialNode] = 0;

        while (!queue.isEmpty()) {
            if (marked[finalNode] == true) return true;
            current = queue.poll();
            marked[current] = true;
            for (int i = 0; i < nodo.get(current).size(); i++) {
                next = nodo.get(current).get(i).getKey();
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
        return marked[finalNode];
    }
}
