package laboratorio;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Gutierrez
 * @version Version 1
 */
public class Laboratorio {

    /**
     * 
     * Calculates the length of the longest common subsequence to two chains of
     * characters.
     *
     *
     * @param x chain of characters.
     * @param y chain of characters.
     * @return length of the longest common subsequence of two chains of characters.
     */
    public static int lcs(String x, String y) {
        if (x.length() == 0 || y.length() == 0) {   
            return 0;                               // C_1
        } else if (x.charAt(x.length() - 1) == y.charAt(y.length() - 1)) {
            return lcs(x.substring(0, x.length() - 1), y.substring(0, y.length() - 1)) + 1;  // 
        } else {
            return Math.max(lcs(x.substring(0, x.length() - 1), y), lcs(x, y.substring(0, y.length() - 1)));   //
        }
    }

    /**
     * Makes the calculation of the ways in which you can place 1x2 rectangles in 2xn ones.
     *
     * @param n is the length of the rectangle that should be used to calculate the number of ways to locate the 1x2 rectangles 
     * @return  ways in which you can fill the 2xn rectangles
     * 
     */
    public static int nRectangulos(int n) {
        if (n == 1) {
            return 1;   //C_1
        }
        if (n == 2) {
            return 2;   //C_2
        }
        return nRectangulos(n - 1) + nRectangulos(n - 2);  //T(n) = C_3 T(n-1) + T(n-2)
    }
}
