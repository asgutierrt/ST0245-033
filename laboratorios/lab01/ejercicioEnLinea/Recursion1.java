
package codingbat_recursion;

/**
 *
 * @author asgutierrt
 * @author sanhidalgoo
 */
public class Recursion1 {
    
    //count7 
    public int count7(int n) {
        if(n==0)  return 0;   

        if(n%10==7) return count7(n/10)+1;
        else  return count7(n/10);
    }
    
    //countX 
    public int countX(String str) {
        if(str.equals(""))return 0;
        
        if(str.charAt(0)=='x') return countX(str.substring(1))+1;
        else return countX(str.substring(1));
    }
    
    //triangle 
    public int triangle(int rows) {
        if(rows==1 || rows==0) return rows;
        else  return rows + triangle(rows-1);
    }
    
    //count8 
    public int count8(int n) {
        if(n<1)return 0;
        
        if (n % 10 == 8 && (n / 10) % 10 == 8) return count8(n/10)+2;
        else if(n%10==8) return count8(n/10)+1;
        else return count8(n/10);
    }
    
    //sumDigits 
    public int sumDigits(int n) {
        if(n<10)return n;
        else{
            int modulo = n%10;
            return modulo+sumDigits(n/10);
        }
    }
}
