package Laboratorio5_2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Ana Sofia Gutiérrez Tejada, Santiago Hidalgo Ocampo
 */
public class DigraphAM extends Digraph {


    /**
     * Constructor para el grafo dirigido
     *
     * @param size el numero de vertices que tendra el grafo dirigido
     */
    int[][] graph;

    public DigraphAM(int size) {
        super(size);
        graph = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino
     *
     * @param source      desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight      el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        this.graph[source][destination] = weight;
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     *
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors = new ArrayList<>();
        boolean empty = true;
        for (int i = 0; i < size; i++) {
            if (graph[vertex][i] == 1) {
                successors.add(i);
                empty = false;
            }
        }
        if (!empty) {
            return successors;
        }
        return null;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     *
     * @param source      desde donde inicia el arco
     * @param destination donde termina el arco
     * @return un entero con dicho peso
     */
    public int getWeight(int source, int destination) {
        return graph[source][destination];
    }

    /**
     * Determine if the graph is BICOLORABLE with the help of the DFS path
     *
     * @param array
     * @param vertex
     * @param color
     * @return true if the graph is BICOLORABLE
     */
    public boolean dfs(int array[], int vertex, int color) {
        array[vertex]=color;
        boolean a = true;
        for (int i = 0; i < size; i++) {
            if (graph[vertex][i] != 0 && array[i] != 1 && array[i] != 2) {
                array[i] = color;
                if (color == 2) {
                    a = dfs(array, i, 1);
                } else {
                    a = dfs(array, i, 2);
                }
            } else if (graph[vertex][i] != 0 && array[i] == 1 && color == 1) return false;
            else if (graph[vertex][i] != 0 && array[i] == 2 && color == 2) ;
        }
        return a;
    }

    /**
     *
     * @param vertex
     * @return true if the graph is BICOLORABLE
     */
    public boolean dfsHelper(int vertex) {
        int array[] = new int[size];
        return dfs(array, vertex, 1);
    }

}