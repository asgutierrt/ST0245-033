package Laboratorio4;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class PreAndPost {

    /**
     * Given a pre-order output of a binary search tree, the post-order output of that same tree is printed
     * @param args
     */
    public static void main(String[] args) {
        int array[] = {50, 30, 24, 5, 28, 45, 98, 52, 60}; //Input
        //The binary search tree is built with the input
        BinaryTree a = new BinaryTree(new Node(array[0]));
        for (int i = 1; i < array.length; i++) {
            a.insertar(array[i]);
        }
        //It is printed postorden
        a.imprimirPos(a.root);
    }
}
