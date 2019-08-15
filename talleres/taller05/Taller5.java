package talleresdatos;

public class Taller5 {

    /**
     * @param array es una arreglo de numeros enteros. El método suma tiene la
     * intención de hacer el proceso de suma mediante una funcion cíclica
     * (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma(int[] array) {
        int suma = 0;                           //c_1
        for (int i = 0; i < array.length; i++) {    //c_2*n + c_3
            suma += array[i];
        }
        return suma;
    }

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado. El
     * método mul tiene la intención de hacer la multiplicación de 1 a n por el
     * numero mul mediante una funcion cíclica (while/for/...)
     *
     */
    public static void mul(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.println(i+ " X "+ j + " = "+ (i*j));
               // int a = i * j;
            }
            // System.out.println("");
        }
    }

    /**
     * @param array es un arreglo de números desordenados El método
     * insertionSort tiene la intención ordenar los números del arreglo array
     * por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion
     * Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     *
     */
    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int auxiliar = a[i];
            int j = i - 1;
            while (a[i] < a[j]) {
                int temporal = a[j];
                a[j] = auxiliar;
                a[i] = temporal;
                i--;
                j--;
                if (j == -1 || i == -1) {
                    break;
                }
            }
        }
        return a;
    }
}
