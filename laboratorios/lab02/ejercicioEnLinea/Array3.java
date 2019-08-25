package laboratorio;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1
 */
public class Array3 {

    /**
     * 1. maxSpan
     * 
     * Consider the leftmost and righmost appearances of some value in an array.
     * We'll say that the "span" is the number of elements between the two inclusive.  A single value has a span of 1
     *
     * @param nums is an array of integers
     * @return  the largest span found in the given array.
     */
    public static int maxSpan(int[] nums) {
        if (nums.length > 0 && nums[0] != nums[nums.length - 1]) {  //T(n) = 
            return nums.length - 1;
        }
        return nums.length;
    }

    /**
     * 2. canBalance
     *
     * @param nums is an array of integers
     * @return true if there is a place to split the array so that the sum of
     * the numbers on one side is equal to the sum of the numbers on the other
     * side.
     */
    public static boolean canBalance(int[] nums) {
        int sumaIzquierda = 0;                      //T(n) = C1
        for (int i = 0; i < nums.length; i++) {     //T(n) = C2*n
            sumaIzquierda += nums[i];               //T(n) = C3*n
            int sumaDerecha = 0;                    //T(n) = C4*n 
            for (int j = nums.length - 1; i < j; j--) { //T(n) = C5*n*n
                sumaDerecha += nums[j];                 //T(n) = C6*n*n
            }
            if (sumaIzquierda == sumaDerecha) {     //T(n) = C7*n
                return true;                         //T(n) = C8*n
            }
        }
        return false;                            //T(n) = C9
    }                                           //T(n) = (C1+C8) + (C2+C3+C4)*n + (C5+C6)*n^2 = C*n^2 + C*n +C

    /**
     * 3. seriesUp
     *
     * @param n is a positive integer
     * @return an array with the pattern {1, 1, 2, 1, 2, 3, ... 1, 2, 3 .. n}
     */
    public static int[] seriesUp(int n) {
        int cont = 0;                           //T(n) = C1
        int[] array = new int[n * (n + 1) / 2]; //T(n) = C2
        for (int i = 1; i <= n; i++) {          //T(n) = C3*n
            for (int j = 1; j <= i; j++) {      //T(n) = C4*n*n
                array[cont++] = j;              //T(n) = C5*n*n
            }
        }
        return array;                            //T(n) = C6
    }                                           //T(n) = (C1+C2+C6) + (C3)*n + (C4+C5)*n*n = C*n^2 + C*n +C

    /**
     * 4. countClumps
     *
     * Say that a "clump" in an array is a series of 2 or more adjacent elements
     * of the same value.
     *
     * @param nums is an array of integers
     * @return Return the number of clumps in the given array.
     */
    public static int countClumps(int[] nums) {
        int count = 0;                                   //T(n) = C1
        for (int i = 0; i < nums.length - 1; i++) {      //T(n) = C2*n
            if (nums[i] == nums[i + 1]) {                 //T(n) = C3*n
                count++;                                    //T(n) = C4*n
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {  //T(n) = C5*n*n
                i++;                                                 //T(n) = C6*n*n
            }
        }
        return count;                                                //T(n) = C7
    }                                                              //T(n) = (C5+C6)*n^2 +(C2+C3+C4)*n+(C1+C7) = C*n^2 + C*n +C

    /**
     * 5. fix34
     *
     * @param nums is an array of integers
     * @return Return an array that contains exactly the same numbers as the
     * given array, but rearranged so that every 3 is immediately followed by a
     * 4
     *
     */
    public int[] fix34(int[] nums) {
        int aux = 0;                                     //T(n) = C1
        for (int i = 0; i < nums.length; i++) {            //T(n) = C2*n
            for (int j = 0; j < nums.length; j++) {         //T(n) = C3*n*n
                if (nums[i] == 4 && nums[j] == 3) {           //T(n) = C4*n*n
                    aux = nums[j + 1];                        //T(n) = C5*n*n
                    nums[j + 1] = nums[i];                      //T(n) = C6*n*n
                    nums[i] = aux;                                   //T(n) = C7*n*n
                }
            }
        }
        return nums;                                  //T(n) = C8
    }                               //T(n) = (C3+C4+C5+C6)n^2 + (C2)*n +(C1+C8) = C*n^2 + C*n +C
}
