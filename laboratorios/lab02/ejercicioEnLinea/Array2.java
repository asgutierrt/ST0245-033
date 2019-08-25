package laboratorio;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutierrez Tejada
 * @version 1
 */
public class Array2 {

    /**
     * 
     * @param nums is is an array of integers
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
    
    
}
