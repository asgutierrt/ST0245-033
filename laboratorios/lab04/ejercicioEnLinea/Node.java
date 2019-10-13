package Laboratorio4;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */

public class Node {

    /**
     * @param right
     * @param left
     * @param data
     */
    public Node right;
    public Node left;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }
}