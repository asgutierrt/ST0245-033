package Laboratorio4;

/**
 *  Implementation of a binary search tree
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */

public class BinaryTree {
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * @param n el dato del nodo que se busca buscar Metodo auxiliar de
     *          insetarAux.
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n    el data del nodo que se busca insertar nota: metodo recursivo.
     *             Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) {
        if (node == null) {
            Node aux = new Node(n);
            node = aux;
        }
        if (n > node.data) {
            if (node.right == null) {
                Node nodeaux = new Node(n);
                node.right = nodeaux;
            }
            insertarAux(node.right, n);
        }
        if (n < node.data) {
            if (node.left == null) {
                Node nodeaux = new Node(n);
                node.left = nodeaux;
            }
            insertarAux(node.left, n);
        }
    }

    /**
     * It is printed postorden
     *
     * @param node
     */
    public void imprimirPos(Node node){
        if(node != null){
            imprimirPos(node.left);
            imprimirPos(node.right);
            System.out.println(node.data);
        }
    }
}
