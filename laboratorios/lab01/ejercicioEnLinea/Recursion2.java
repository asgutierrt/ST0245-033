
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
     * @param nums is an array of integers
     * @return true if it is possible to divide the elements of the arrangement into two groups,
     * so that the sum of one group is a multiple of 10 and the sum of the other group is odd
     */
    public boolean splitOdd10(int[] nums) {
        return splitOdd10Aux ( nums, 0, 0,  nums.length-1);
    }
    /**
     * Auxiliary method for splitOdd10 
     *
     * @param nums is an array of integers
     * @param sum1 partial sum of a group of the arrangement
     * @param sum2 partial sum of a group of the arrangement
     * @param n length of the array -1
     * @return true if it is possible to divide the elements of the arrangement into two groups,
     * so that the sum of one group is a multiple of 10 and the sum of the other group is odd
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
     * @param start index to go over the arrangement
     * @param nums is an array of integers
     * @param target is the goal sum
     * @return the truth or falsity of the equality of the sum with the given condition
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        return groupSum5Aux (0,nums,target);
    }
    
    /**
     * Auxiliary method for groupSum5
     * 
     * @param start index to go over the arrangement
     * @param nums is an array of integers
     * @param target is the goal sum
     * @return the truth or falsity of the equality of the sum with the given condition
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
     * @param nums is an array of integers
     * @return truth or falsehood about the equality of the sum of two arrangement groups
     */
     public static boolean splitArray(int[] nums) {
        return splitAux(0, 0, 0, nums);
    }
    
    /**
     * Auxiliary method for splitArray
     * 
     * @param start index to go over the arrangement
     * @param sum1 is the sum of a subgroup of the array
     * @param sum2 is the sum of a subgroup of the array
     * @param nums is an array of integers
     * @return truth or falsehood about the equality of the sum of two arrangement groups
     */
    public static boolean splitAux(int start, int sum1, int sum2, int[] nums) {
        if (start == nums.length) {
            return sum1 == sum2;
        } else {
            return splitAux(start + 1, sum1 + nums[start], sum2, nums)
                    || splitAux(start + 1, sum1, sum2 + nums[start], nums);
        }
    }
    
    /**
     * 4. groupNoAdj
     * 
     * @param start index to go over the arrangement
     * @param nums is an array of integers
     * @param target is the target sum of the subgroup of the array
     * @return true if the arrangement has a subgroup that sums up the objective
     * with the given restriction
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
          return groupNoAdjAux(start, nums,target,false);
    }
    
    /**
     * Auxiliary method for groupNoAdj
     * 
     * @param start index to go over the arrangement
     * @param nums is an array of integers
     * @param target is the target sum of the subgroup of the array
     * @param chosen true if the item in the current position is chosen
     * @return true if the arrangement has a subgroup that sums up the objective
     * with the given restriction
     */
    public boolean groupNoAdjAux(int start, int[] nums, int target, boolean chosen) {
      if (chosen & start<=nums.length-1){
        return groupNoAdjAux(start+1, nums, target, false); 
      }
      if (start==nums.length){
        return target ==0; 
      }
      return groupNoAdjAux(start+1, nums, target-nums[start], true)||
             groupNoAdjAux(start+1, nums, target, false);
    }
    
     /**
     * 5. split53 
     * 
     * @param nums is an array of integers
     * @return true if two subgroups of the arrangement add up to the same value following
     * the restriction given
     */
    public boolean split53(int[] nums) {
      return split53Aux(0,0,0, nums);
    }
    
    /**
     * Auxiliary method for split53
     * 
     * @param start index to go over the arrangement
     * @param sum1 is the sum of the subgroup 1 of the array
     * @param sum2 is the sum of the subgroup 2 of the array
     * @param nums is an array of integers
     * @return true if two subgroups of the arrangement add up to the same value following
     * the restriction given
     */
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
