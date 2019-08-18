
package codingbat_recursion;

/**
 *
 * @author asgutierrt
 * @author sanhidalgoo
 */
public class Recursion2 {
    //
    
     /**
     * 1. splitOdd10 
     *
     * @param nums es un arreglo de enteros
     * @return  verdad si es posible dividir los elementos del arreglo en dos grupos, 
     * de modo que la suma de un grupo sea múltiplo de 10 y la suma del otro grupo sea impar
     */
    public boolean splitOdd10(int[] nums) {
        return splitOdd10Aux ( nums, 0, 0,  nums.length-1);
    }
    /**
     * Método auxiliar splitOdd10 
     *
     * @param nums es un arreglo de enteros
     * @param sum1 suma parcia2 de un grupó del arreglo
     * @param sum2 suma parcial2 de un grupo del arreglo
     * @param n longitud del arreglo-1
     * @return verdad si es posible dividir los elementos del arreglo en dos grupos, 
     * de modo que la suma de un grupo sea múltiplo de 10 y la suma del otro grupo sea impar
     */
    public boolean splitOdd10Aux (int[] nums, int sum1, int sum2, int n) {
      if (n<0){
        return sum1%10==0 & sum2%2==1;
      }else return splitOdd10Aux(nums, sum1+nums[n], sum2, n-1) ||   //T(n)= c_2 + T(n-1) + T(n-1)
                  splitOdd10Aux(nums, sum1, sum2+nums[n], n-1);      
    }
    
    
    /**
     * 2. groupSum5
     * 
     * @param start indice para recorrer el arreglo
     * @param nums es un arreglo de enteros
     * @param target es la suma objetivo
     * @return la verdad o falsedad de la igualdad de la suma con la condición dada
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        return groupSum5Aux (0,nums,target);
    }
    
    /**
     * Método auxiliar para groupSum5
     * 
     * @param start indice para recorrer el arreglo
     * @param nums es un arreglo de enteros
     * @param target es la suma objetivo
     * @return la verdad o falsedad de la igualdad de la suma con la condición dada
     *
     */
    public boolean groupSum5Aux(int start, int[] nums, int target) {
        if (start<nums.length-1){
            if (nums[start]%5==0 & nums[start+1]!=1) return groupSum5Aux (start+1,nums,target-nums[start]); //T(n)= c_1 + T(n-1)
            if (nums[start]%5==0 & nums[start+1]==1) return groupSum5Aux (start+2,nums,target-nums[start]); //T(n)= c_1 + T(n-1)
        }

        if (start==nums.length){
            if (target ==0) return true;   //T(n)= c_2
            else return false;
        }

        return groupSum5Aux(start+1, nums, target-nums[start])||  //T(n)= c_3 + T(n-1) + T(n-1)
                                                                  //it does not executes this line and the one above (line 32-33) in the same recursion, only one does, so they must not be added
               groupSum5Aux(start+1, nums, target);
    }
    
    /**
     * 3. splitArray
     * 
     * @param nums arreglo de enteros
     * @return verdad o falsedad sobre la igualdad de la suma de dos grupos del arreglo
     */
     public static boolean splitArray(int[] nums) {
        return splitAux(0, 0, 0, nums);
    }
    
    /**
     * Método auxilar para splitArray
     * 
     * @param start es el indice para recorrer el arreglo
     * @param sum1 es la suma de un subgrupo del arreglo
     * @param sum2 es la suma de un subgrupo del arreglo
     * @param nums es un arreglo de enteros
     * @return  verdad o falsedad sobre la igualdad de la suma de dos grupos del arreglo
     */
    public static boolean splitAux(int start, int sum1, int sum2, int[] nums) {
        if (start == nums.length) {
            return sum1 == sum2;
        } else {
            return splitAux(start + 1, sum1 + nums[start], sum2, nums)
                    || splitAux(start + 1, sum1, sum2 + nums[start], nums);
        }
    }
    
    //4. groupNoAdj
    public boolean groupNoAdj(int start, int[] nums, int target) {
    return groupNoAdjAux(start, nums,target,false);
    }

    public boolean groupNoAdjAux(int start, int[] nums, int target, boolean chosen) {
      if (chosen & start<=nums.length-1){
        return groupNoAdjAux(start+1, nums, target, false); 
      }

      if (start==nums.length){
        if (target ==0) return true;
        else return false;
      }

      return groupNoAdjAux(start+1, nums, target-nums[start], true)||
             groupNoAdjAux(start+1, nums, target, false);
    }
    
    //5. split53 
    public boolean split53(int[] nums) {
      return split53Aux(0,0,0, nums);
    }
    public boolean split53Aux(int start, int sum1, int sum2, int[] nums) {
      if (start<nums.length){
        if (nums[start]%5==0) return split53Aux (start+1,sum1+nums[start], sum2, nums);
        if (nums[start]%3==0 & nums[start]%5!=0) return split53Aux (start+1,sum1, sum2+nums[start], nums);
      }

      if (start == nums.length) {
        return sum1 == sum2;
      } else {
        return split53Aux(start + 1, sum1 + nums[start], sum2, nums) ||
                split53Aux(start + 1, sum1, sum2 + nums[start], nums);
      }
    }
    
}
