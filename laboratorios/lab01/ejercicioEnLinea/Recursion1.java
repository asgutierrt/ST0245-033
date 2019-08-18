
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
     * @param n es el número al cual que le quiere contar las ocurrencias del 7
     * @return La cantidad de ocurrencias del 7 en el número dado. 
     */
    public int count7(int n) {
        if(n==0)  return 0;       //T(n)= c_1

        if(n%10==7) return count7(n/10)+1;   //T(n)= c_2 + T(n/10)
        else  return count7(n/10);           
    }
    
   /**
     * 2. countX 
     * 
     * @param str es una cadena de caracteres 
     * @return La cantidad de ocurrencias de 'x' en la cadena dada
     */
    
    public int countX(String str) {
        if(str.equals(""))return 0;        //T(n)= c_1
        
        if(str.charAt(0)=='x') return countX(str.substring(1))+1;   //T(n)= c_2 + T(n-1)
        else return countX(str.substring(1));
    }
    
     /**
     * 3. triangle 
     * 
     * @param rows es el número de filas que posee el triángulo
     * @return El número total de bloques que posee el triagulo 
     */
    public int triangle(int rows) {
        if(rows==1 || rows==0) return rows;   //T(n)= c_1
        else  return rows + triangle(rows-1);   //T(n)= c_2 + T(n-1)
    }
    
     /**
     * 4. count8 
     * 
     * @param n es un número entero no negativo
     * @return el número de ocurrencias de '8' en el número con 
     *          la restricción dada.
     */
    public int count8(int n) {
        if(n<1)return 0;       //T(n)= c_1
        
        if (n % 10 == 8 && (n / 10) % 10 == 8) return count8(n/10)+2;   //T(n)= c_2 + T(n/10)
        else if(n%10==8) return count8(n/10)+1;
        else return count8(n/10);
    }
    
    //5. sumDigits 
    public int sumDigits(int n) {
        if(n<10)return n;     //T(n)= c_1
        else{
            int modulo = n%10;
            return modulo+sumDigits(n/10);  //T(n)= c_2 + T(n/10)
        }
    }
}
