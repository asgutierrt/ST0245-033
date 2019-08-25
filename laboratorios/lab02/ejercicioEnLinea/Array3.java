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
        if (nums.length > 0 && nums[0] != nums[nums.length - 1]) {
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
        int sumaIzquierda = 0;

        for (int i = 0; i < nums.length; i++) {
            sumaIzquierda += nums[i];
            int sumaDerecha = 0;
            for (int j = nums.length - 1; i < j; j--) {
                sumaDerecha += nums[j];
            }
            if (sumaIzquierda == sumaDerecha) {
                return true;
            }
        }
        return false;
    }

    /**
     * 3. seriesUp
     *
     * @param n is a positive integer
     * @return an array with the pattern {1, 1, 2, 1, 2, 3, ... 1, 2, 3 .. n}
     */
    public static int[] seriesUp(int n) {
        int cont = 0;
        int[] array = new int[n * (n + 1) / 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                array[cont++] = j;
            }
        }
        return array;
    }

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
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return count;
    }

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
        int aux = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == 4 && nums[j] == 3) {
                    aux = nums[j + 1];
                    nums[j + 1] = nums[i];
                    nums[i] = aux;
                }
            }
        }
        return nums;
    }
}
