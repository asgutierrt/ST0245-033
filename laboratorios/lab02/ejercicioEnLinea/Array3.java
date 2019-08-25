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
     * @param nums is an array of integers
     * @return
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
     * @return  true if there is a place to split the array so that the sum of 
     * the numbers on one side is equal to the sum of the numbers on the other side.
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
    
    

}
