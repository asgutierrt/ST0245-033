package laboratorio;

/**
 * Clase que contiene las pruebas de los ejercicios del Laboratorio
 * 
 * @author Santiago Hidalgo Ocampo
 * @author Ana Gutierrez
 * @version Versión 1
 */
public class Main {

    public static void main(String[] args) {
        //Ejercicio 1
        ejercicio1(); // ADN

        //Ejercicio2
        ejercicio2(); //Rectangulos...
    }

    //Pruebas Ejercicio 1 (ADN
    public static void ejercicio1() {
        System.out.println("Ejercicio número 1: ");
        System.out.println("Ejemplo 1: ");
        String x = "ATAMOS";
        String y = "MATAMOSCAS";
        System.out.println(x + " , " + y + "\n La longitud de la subsecuencia más larga entre las dos cadenas es: " + Laboratorio.lcs(x, y));
        System.out.println("");
        System.out.println("Ejemplo 2: ");
        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(a + " , " + b + "\n La longitud de la subsecuencia más larga entre las dos cadenas es: " + Laboratorio.lcs(a, b));
        System.out.println("\n");
    }

    //Pruebas ejercicio 2 (Rectangulos)
    public static void ejercicio2() {
        System.out.println("Ejercicio 2: ");
        for (int i = 1; i < 7; i++) {
            System.out.println("Para un rectangulo de medidas 2x"+i+" se puede \"rellenar\" de "+ 
                    Laboratorio.nRectangulos(i)+ " maneras con rectangulos de 2x1");
        }
    }
}
