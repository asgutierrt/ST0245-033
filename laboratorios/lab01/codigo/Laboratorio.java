package laboratorio;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Gutierrez
 * @version Versión 1
 */
public class Laboratorio {

    /**
     * Calcula la longitud de la subsecuencia común más larga a dos cadenas de
     * caracteres.
     *
     *
     * @param x Cadena de caracteres
     * @param y Cadena de caracteres
     * @return Longitud de la subsecuencia común más larga a dos cadenas de
     * caracteres.
     */
    public static int lcs(String x, String y) {
        if (x.length() == 0 || y.length() == 0) {   
            return 0;                                // C_1
        } else if (x.charAt(x.length() - 1) == y.charAt(y.length() - 1)) {
            return lcs(x.substring(0, x.length() - 1), y.substring(0, y.length() - 1)) + 1;  
        } else {
            return Math.max(lcs(x.substring(0, x.length() - 1), y), lcs(x, y.substring(0, y.length() - 1)));
        }
    }

    /**
     * Realiza el calculo de las formas en las cuales se pueden ubicar los
     * rectangulos 1x2 en otro 2xn ademas dibuja cada una de ellas
     *
     * @param n es el largo del rectangulo que se debe de utilizar para calcular
     * el numero de formas de ubicar el rectangulo 1x2
     * @return int retorna un entero que representa las formas en las que se
     * puede llenar el rectangulo 2xn
     */
    public static int nRectangulos(int n) {
        if (n == 1) {
            return 1;   //C_1
        }
        if (n == 2) {
            return 2; //C_2
        }
        return nRectangulos(n - 1) + nRectangulos(n - 2); //T(n) = C_3 T(n-1) + T(n-2)
    }
}
