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
        int cont = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                cont++;
            }
        }
        return cont;
    }

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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
            } else {
                suma += nums[i];
            }
        }
        return suma;
    }

    /**
     * 3. lucky13
     *
     * @param nums is an array of integers
     * @return true if the array contains no 1's and no 3's.
     */
    public static boolean lucky13(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3 || nums[i] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 4. no14
     *
     * @param nums is an array of integers
     * @return true if it contains no 1's or it contains no 4's
     */
    public static boolean no14(int[] nums) {
        boolean one = false;
        boolean two = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one = true;
            }
            if (nums[i] == 4) {
                two = true;
            }
        }
        return !(one && two);
    }

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