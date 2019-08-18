package laboratorio;

/**
 * tests for Lab 1 code exercises
 * 
 * @author Santiago Hidalgo Ocampo
 * @author Ana Gutierrez
 * @version Version 1
 */
public class Main {

    public static void main(String[] args) {
        //exercise 1
        ejercicio1(); // ADN

        //exercise 2
        ejercicio2(); //Rectangles...
    }

    //tests exercise 1: ADN
    public static void ejercicio1() {
        System.out.println("exercise number 1: ");
        System.out.println("example 1: ");
        String x = "ATAMOS";
        String y = "MATAMOSCAS";
        System.out.println(x + " , " + y + "\n The length of the longest sub-sequence between the two chains is: " + Laboratorio.lcs(x, y));
        System.out.println("");
        System.out.println("example 2: ");
        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(a + " , " + b + "\n The length of the longest sub-sequence between the two chains is: " + Laboratorio.lcs(a, b));
        System.out.println("\n");
    }

    //tests exercise 2 (Rectangles)
    public static void ejercicio2() {
        System.out.println("Exercise 2: ");
        for (int i = 1; i < 7; i++) {
            System.out.println("A rectangle of measures 2x"+i+" can be \"fill\" in "+ 
                    Laboratorio.nRectangulos(i)+ " ways with 2x1 rectangles");
        }
    }
}
