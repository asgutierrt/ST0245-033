package Taller10;

import java.util.ArrayList;

/**
 * La clase BinaryTree intenta dar un conocimiento a los estudiantes acerca del
 * manejo de un arbol binario de enteros. Aquí se espera crear una estrcutura
 * concreta del árbol binario, cabe aclarar que esta estrucutra ya esta
 * implementada.
 *
 * @see
 * <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html">
 * Árbol Binario</a>
 * @author Mauricio Toro, Andres Paez
 * 
*/
public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * @param n el dato del nodo que se busca buscar Metodo auxiliar de
     * insetarAux.
     *
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
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
     * @param n el dato del nodo que se busca. Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca nota: metodo recursivo. Inserta un
     * dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo
     * contrario
     */
    private boolean buscarAux(Node node, int n) {
        if (node == null) {
            return false;
        }
        if (node != null) {
            if (n < node.data) {
                return buscarAux(node.left, n);
            }
            if (n > node.data) {
                return buscarAux(node.right, n);
            }
            return node.data == n;
        }
        return false;
    }

    /**
     * @param n el dato del nodo que se busca borrar. Metodo auxiliar de
     * buscarAux.
     *
     */
    public BinaryTree borrar(int n) {
        return borrarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca borrar nota: metodo recursivo.
     * borra un dato respetando claro las desigualdades en el árbol
     */
    private BinaryTree borrarAux(Node node, int n) {

        BinaryTree tree = null;
        ArrayList<Integer> list = new ArrayList<>();
        list = TreetoString(root, list);
        //System.out.println(list.toString());

        int x = list.size() - 1;
        if (n == list.get(list.size() - 1)) {
            x = 1;
        }

        tree = new BinaryTree(new Node(list.get(x)));

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != n) {
                tree.insertar(list.get(i));
            }

        }
        return tree;
    }

    private ArrayList<Integer> TreetoString(Node node, ArrayList<Integer> list) {

        if (node != null) {
            TreetoString(node.left, list);
            TreetoString(node.right, list);
            list.add(node.data);
        }
        return list;
    }


    /* 
     Los metodos posteriores son para imprimir el arbol de manera
     que sirven para debuggeo
     */
    /**
     * @param node el nodo desde el cual se imprimirá imprime el arbol desde el
     * nodo node
     */
    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    private void recursivePrintAUX(Node node) {

        if (node != null) {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }

}
