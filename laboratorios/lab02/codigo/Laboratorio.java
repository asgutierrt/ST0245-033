package laboratorio;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1
 *
 */
public class Laboratorio {

    /*Sorts an array using Insertion Sort
    *
    * Title: InsertionSort
    * Autor: Mauricio Toro
    * Date: 2018
    * Availability: https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab02/codigo_estudiante/Java/Laboratory1/Laboratory1.java
     */
    public static void insertionSort(int[] A) {
        int temp, j;
        for (int i = 0; i < A.length; i++) {
            j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j = j - 1;
            }
        }
    }

    /**
     * Sorts an array using Merge Sort Taken from www.cs.cmu.edu/
     *
     * @param a is an array of integers
     */
    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left] <= a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }
        while (left <= leftEnd) // Copy rest of first half
        {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) // Copy rest of right half
        {
            tmp[k++] = a[right++];
        }

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }

    
    /**
     * Method that fills an array of size n with random integers
     *
     * @param tam is is the size of the array to build
     * @return array
     */
    public static int[] arrayReturn(int tam) {
        int[] array = new int[tam];
        Random ra = new Random();
        for (int i = 0; i < tam; i++) {
            array[i] = ra.nextInt(5000);
        }
        return array;
    }

    public static void main(String[] args) {

        System.out.println("TIMES WITH INSERTION SORT");
        int times = 1;
        for (int i = 100000; i <= 400000; i += 15000) {
            int A[] = arrayReturn(i);
            long startTime = System.currentTimeMillis();
            insertionSort(A);
            long endTime = System.currentTimeMillis();
            System.out.println(times + ". n = " + i + "        Time = " + (endTime - startTime));
            times++;
        }

        System.out.println("");
        System.out.println("TIMES WITH MERGE SORT");
        int times2 = 1;
        for (int i = 100000; i <= 400000; i += 15000) {
            int A[] = arrayReturn(i);
            long startTime = System.currentTimeMillis();
            mergeSort(A);
            long endTime = System.currentTimeMillis();
            System.out.println(times2 + ". n = " + i + "        Time = " + (endTime - startTime));
            times2++;
        }
    }

}
