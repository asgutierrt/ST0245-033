
package codingbat_recursion;

/**
 *
 * @author asgutierrt
 * @author sanhidalgoo
 */
public class Recursion1 {
    
   
    /**
     * 1. count7 
     * 
     * @param n it is the number to which you want to count the occurrences of 7
     * @return The number of occurrences of 7 in the given number. 
     */
    public int count7(int n) {
        if(n==0)  return 0;       //T(n)= c_1

        if(n%10==7) return count7(n/10)+1;   //T(n)= c_2 + T(n/10)
        else  return count7(n/10);           
    }
    
   /**
     * 2. countX 
     * 
     * @param str it is a string of characters
     * @return The number of occurrences of 'x' in the given string
     */
    
    public int countX(String str) {
        if(str.equals(""))return 0;        //T(n)= c_1
        
        if(str.charAt(0)=='x') return countX(str.substring(1))+1;   //T(n)= c_2 + T(n-1)
        else return countX(str.substring(1));
    }
    
     /**
     * 3. triangle 
     * 
     * @param rows is the number of rows in the triangle
     * @return The total number of blocks that the triangle has 
     */
    public int triangle(int rows) {
        if(rows==1 || rows==0) return rows;   //T(n)= c_1
        else  return rows + triangle(rows-1);   //T(n)= c_2 + T(n-1)
    }
    
     /**
     * 4. count8 
     * 
     * @param n is an non negative integer
     * @return the number of occurrences of '8' in the number with
     * the restriction given.
     */
    public int count8(int n) {
        if(n<1)return 0;       //T(n)= c_1
        
        if (n % 10 == 8 && (n / 10) % 10 == 8) return count8(n/10)+2;   //T(n)= c_2 + T(n/10)
        else if(n%10==8) return count8(n/10)+1;
        else return count8(n/10);
    }
    
     /**
     * 5. sumDigits 
     * 
     * @param n is a random number
     * @return the sum of the digits of the given number
     */
    public int sumDigits(int n) {
        if(n<10)return n;     //T(n)= c_1
        else{
            int modulo = n%10;
            return modulo+sumDigits(n/10);  //T(n)= c_2 + T(n/10)
        }
    }
}
