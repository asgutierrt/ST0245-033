package talleresdatos;

import java.util.Random;

/**
 *
 * @author SanHidalgo
 */
public class Main {

    //Taller 5
    public static boolean ejercicio1() {
        int a, b, c, d;
        a = Taller5.suma(new int[]{1, 2, 3, 4, 5, 5});
        b = Taller5.suma(new int[]{12, 324, 43, 2, 3, 43, 2, 3, 43});
        c = Taller5.suma(new int[]{3, 2, 343, 2, 43, 55, 67, 68, 86, 3, 4});
        d = Taller5.suma(new int[]{56, 7, 6, 45, 8, 4, 34, 8, 7, 5, 34, 7, 78, 9});
        if (a != 20 || b != 475 || c != 676 || d != 308) {
            return false;
        }
        return true;
    }

    public static void ejercicio2() {
        Taller5.mul(2);
        Taller5.mul(5);
        Taller5.mul(7);
        Taller5.mul(8);
    }

    public static boolean ejercicio3() {
        int[] temp;
        String a, b, c, d;
        String temps = "";

        temp = Taller5.insertionSort(new int[]{3, 2, 343, 2, 43, 55, 67, 68, 86, 3, 4});
        for (int i = 0; i < temp.length; i++) {
            temps += temp[i] + " ";
        }
        a = temps;

        temps = "";
        temp = Taller5.insertionSort(new int[]{54, 3, 5, 6, 3, 6, 456, 867, 3, 45, 6, 3, 45, 34, 345});
        for (int i = 0; i < temp.length; i++) {
            temps += temp[i] + " ";
        }
        b = temps;

        temps = "";
        temp = Taller5.insertionSort(new int[]{564, 645, 76, 45, 64, 3, 53, 235, 5, 353, 4645});
        for (int i = 0; i < temp.length; i++) {
            temps += temp[i] + " ";
        }
        c = temps;

        temps = "";
        temp = Taller5.insertionSort(new int[]{876, 543, 3463, 345, 46, 34, 52, 235, 46, 7, 34, 235, 64, 345, 3});
        for (int i = 0; i < temp.length; i++) {
            temps += temp[i] + " ";
        }
        d = temps;

        if (a.equals("2 2 3 3 4 43 55 67 68 86 343 ")
                && b.equals("3 3 3 3 5 6 6 6 34 45 45 54 345 456 867 ")
                && c.equals("3 5 45 53 64 76 235 353 564 645 4645 ")
                && d.equals("3 7 34 34 46 46 52 64 235 235 345 345 543 876 3463 ")) {
            return true;
        }
        return false;
    }

    //Metodo para crear arreglos aleatorios
    public static int[] arrayretorno(int tam) {
        int[] array = new int[tam];
        Random ra = new Random();
        for (int i = 0; i < tam; i++) {
            array[i] = ra.nextInt(10);
        }
        return array;
    }

    public static void main(String[] args) {

        //Ejercicio1 suma
        if (ejercicio1()) {
            System.out.println("Ejercicio 1 Correcto");
        } else {
            System.out.println("Ejercicio 1 Incorrecto");
        }

        //Tiempos ejercicio 1 (suma)
        for (int i = 2000000; i < 21000000; i += 1000000) {
            long start = System.currentTimeMillis();
            int[] array = arrayretorno(i);
            Taller5.suma(array);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        //Ejercicio2 (multiplicar)
        System.out.println("");
        System.out.println("Ejercicio 2");
        ejercicio2();

        //Tiempos ejercicio 2 (Multiplicar)
        for (int i = 200; i < 220; i++) {
            long start = System.nanoTime();
            Taller5.mul(i);
            long end = System.nanoTime();
            System.out.println(end - start);
        }

        //Ejercicio3 
        if (ejercicio3()) {
            System.out.println("Ejercicio 3 Correcto");
        } else {
            System.out.println("Ejercicio 3 Incorrecto");
        }

        //Tiempos ejercicio 3
        for (int i = 200000; i < 300000; i += 10000) {
            long start = System.currentTimeMillis();
            int[] array = arrayretorno(i);
            Taller5.insertionSort(array);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }

    }
}
