package taller6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1
 */
public class Taller6 {

    /**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime. el arreglo
     * tiene que estar de forma inversa ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
     *
     * @return un arraylist con todos los elementos ingresados de forma
     * invertida
     */
    public static ArrayList<Integer> opcinal2() {
       ArrayList<Integer> numbers =  new ArrayList<>(); //C_1
       Scanner input = new Scanner(System.in); //C_2
       int num; //C_3
       do{
            num = input.nextInt();  //C4
            if(num!=-1) numbers.add(0,num); //C_5*n
       } while (num!=-1); //C_6*n (n sinedo la longitud de numbers)
        return numbers; 
        //Complejidad: O(n^2) (n sinedo la longitud de numbers)
    }

    /**
     * @param n el numero hasta el cual se llevara acabo el patrón siguiente
     * vamos a implementar un nuevo nuevo a la vez no antes de haber contado
     * desde el inicio ejemplo n=4 entonces el arreglo sería [
     * 1,1,2,1,2,3,1,2,3,4] de modo que siempre que se ingresa uno nuevo
     * comienza la cuenta desde 1.
     * @return un arraylist con todos los elementos ingresados
     */
    public static ArrayList<Integer> opcinal3(int n) {
     ArrayList<Integer> numbers =  new ArrayList<>(); //C_1
        for (int i = 0; i <= n; i++) { //C_2*n
            for (int j = 1; j < i+1; j++) //C_3*n*m 
                numbers.add(j);   // C_4*m*n^2
        }
        return numbers; //Complejidad: O(n^2*m)  n siendo el número ingresado
                                              // y m números del 1 a n 
   }
}
