package Taller10;

public class Main {

    public static void main(String[] args) {
        BinaryTree a = new BinaryTree(new Node(3));
        int[] b = {67, 1, 4, 8, 2, 5, 9};
        for (int i = 0; i < b.length; i++) {
            a.insertar(b[i]);
        }
        System.out.println(a.buscar(3));
        a.recursivePrint();
        BinaryTree k = a.borrar(67);
        System.out.println("");
        k.recursivePrint();
    }
}
