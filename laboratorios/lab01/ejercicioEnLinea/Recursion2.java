
package codingbat_recursion;

/**
 *
 * @author asgutierrt
 * @author sanhidalgoo
 */
public class Recursion2 {
    //splitOdd10 
    public boolean splitOdd10(int[] nums) {
        return splitOdd10Aux ( nums, 0, 0,  nums.length-1);
    }

    public boolean splitOdd10Aux (int[] nums, int sum1, int sum2, int n) {
      if (n<0){
        if (sum1%10==0 & sum2%2==1) return true;
        else return false;
      }
      
      else return splitOdd10Aux(nums, sum1+nums[n], sum2, n-1) || 
                  splitOdd10Aux(nums, sum1, sum2+nums[n], n-1);
    }
    
    //groupSum5
    
}
