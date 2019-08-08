/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 *
 * @author asgutierrt
 */
public class Taller4 {
    /**
	* @param array es un arreglo de numeros enteros
	* @param n la longitud del array anterior 
	*
	*en este método se busca hacer la suma de los numeros en un
	*arreglo de forma recursiva.
	*
	* @return la suma
	*/
	public static int arrayMax(int[] array, int n) {
            if (n==0) return array[n];                            //c_1
            return array[n] + arrayMax(array, n-1);               //t(n)= c_2 + t(n-1)
	}
    
    /**
	* @param start es un contador, nos sirve para saber cuando debemos parar
	* @param array es un arreglo de numeros enteros, representan volumen
	* @param target es la meta, el numero que debe alacanzar la suma 
	*
	* en este método se busca hacer la suma de los volumnes posibles
	* de modo que se acomode de tal forma que se alcance el valor target
	* pista: la clave esta en el numero de elementos y que no siempre se toman
	* los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
	* target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
	*
	*
	* @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
	*/
	public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;                                             //c_1
            return groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target);    //t(n)= c_2 + t(n-1) + t(n-1)
    }
	
	
	/**
	* @param n numero entero, hasta que numero se hace la serie
	*
	* el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
	* @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
	* @return el valor encontrado en long dada la posible cantidad de bits
	*/
	
        public static long fibonacci(int n) { 
            if (n==2 || n==1) return 1;                           // c_1
            return fibonacci(n-1) + fibonacci (n-2);        // t(n)= c_2 + t(n-1) + t(n-2)
            
	}
       
}
