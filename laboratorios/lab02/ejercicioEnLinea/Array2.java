package laboratorio;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutierrez Tejada
 * @version 1
 */
public class Array2 {

    /**
     * 1. countEvens
     *
     * @param nums is an array of integers
     * @return the number of even ints in the given array.
     */
    public static int countEvens(int[] nums) {
        int cont = 0;                               //C_1
        for (int i = 0; i < nums.length; i++) {     // C_2*n
            if (nums[i] % 2 == 0) {                 // C3_*n
                cont++;                             // C_4*n
            }
        }
        return cont;                                // C_5
    }                                             // T(n) = C1 + (C_2+C_3+C4)*n + C_5

    /**
     * 2. sum13
     *
     * @param nums is an array of integers
     * @return Return the sum of the numbers in the array, returning 0 for an
     * empty array. Except the number 13 is very unlucky, so it does not count
     * and numbers that come immediately after a 13 also do not count.
     */
    public static int sum13(int[] nums) {
        int suma = 0;
        for (int i = 0; i < nums.length; i++) {    //T(n) = n
            if (nums[i] == 13) {                   // T(n) = C1*n
                i++;                               //  T(n) = C2*n
            } else {
                suma += nums[i];                    // T(n) = C3*n
            }
        }
        return suma;                                 // T(n) = C4
    }                                               //T(n) = (C0*n)+C1

    /**
     * 3. lucky13
     *
     * @param nums is an array of integers
     * @return true if the array contains no 1's and no 3's.
     */
    public static boolean lucky13(int[] nums) {
        for (int i = 0; i < nums.length; i++) {  //T(n) = n
            if (nums[i] == 3 || nums[i] == 1) {  //T(n) = C1*n
                return false;                    // T(n) = C2*n
            }
        }
        return true;                              //T(n) = C3
    }                                           //T(n) = (C1*n) + (C2+C3) = C1*n + C

    /**
     * 4. no14
     *
     * @param nums is an array of integers
     * @return true if it contains no 1's or it contains no 4's
     */
    public static boolean no14(int[] nums) {
        boolean one = false;                     //T(n)=C1
        boolean two = false;                     //T(n) = C2
        for (int i = 0; i < nums.length; i++) {    // T(n) = n
            if (nums[i] == 1) {                     // T(n) = n*C3
                one = true;                           // T(n) = n*C4  
            }
            if (nums[i] == 4) {                   // T(n) = n*C5
                two = true;                    // T(n) = n*C6
            }
        }
        return !(one && two);                   // T(n) = C7
    }                                           // T(n) = (n*C) + C1

    /**
     * 5. has22
     * 
     * @param nums is an array of integers
     * @return  true if the array contains a 2 next to a 2 somewhere
     */
    public static boolean has22(int[] nums) {
        if (nums.length == 2 && nums[0] == 2 && nums[1] == 2) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }
        }
        return false;
    }
}
