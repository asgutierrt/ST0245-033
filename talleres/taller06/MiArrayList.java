package taller6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule
 * el comportamiento de la clase ya implementada "ArrayList" es claro que no se
 * puede utilizar dicha estructura ya utilizada dentro de este ejercicio. Para
 * más información de la clase ArrayList:
 *
 * @see
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">
 * Ver documentacion ArrayList </a>
 *
 *
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */
public class MiArrayList {
   //tests para metodos add y del
    public static void main(String[] args) {
        MiArrayList numbers = new MiArrayList();
        numbers.add(2);
        numbers.add(7);
        numbers.add(78);
        numbers.add(1);
        System.out.println(numbers);
        numbers.add(2,56);
        System.out.println(numbers);
        numbers.del(2);
        System.out.println(numbers);
        
    }
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    /**
     * El metodo constructor se utiliza para incializar variables a valores
     * neutros como 0 o null. El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }

    /**
     * Tiene la intención de retornar la longitud del objeto
     *
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return this.size;
    }

    /**
     * @param e el elemento a guardar Agrega un elemento e a la última posición
     * de la lista
     *
     */
    public void add(int e) {
        if (size == elements.length) { // C1 = 2      O(1)
            int[] nuevo = new int[elements.length * 2]; // C2 = 3   O(1)
            for (int i = 0; i < elements.length; i++) // C3 + C4n O(n)
            {
                nuevo[i] = elements[i];  // C5n             O(n)
            }
            elements = nuevo;    //C6         O(1)
        }
        elements[size] = e; // C7        O(1)
        size++; // C8            O(1)
    }                       // __________________+o(n)
    //   T(n) = C1 + C2 + C3 + C4n... es O(n)

    /**
     * @param i es un íncide donde se encuentra el elemento posicionado Retorna
     * el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        if (i < size && i >= 0) //C_1
        {
            return elements[i]; //C_2
        } else {
            throw new ArrayIndexOutOfBoundsException(); //C_3
        }
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar Agrega un elemento e en la posición index
     * de la lista
     *
     */
    public void add(int index, int e) {
        if (index >= 0 & index<size) {
            int[] nuevo = new int[size+1];    //c1
            for(int i=0; i<index; i++){       
                nuevo[i]=elements[i];         //c2*(index)
            }
            nuevo[index]= e;                  //c3
            int a=index;                      //c4
            for(int j=index+1; j<size+1;j++){ 
                nuevo[j]=elements[a];         //c5*(n-index)
                a++;
            }
            elements = nuevo;          //c6
            size++;                    //c7
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }                               //complejidad: O(index+n-index)= O(n)
    }                                   //donde n es la longitud de elements

    /**
     * @param index es la posicion en la cual se va a eliminar el elemento
     *
     * ELimina el elemento en la posición index de la lista
     *
     */
    public void del(int index) {
         if (index >= 0 & index<size) {
            int[] nuevo = new int[size-1];    //c1  
            for(int i=0; i<index; i++){
                nuevo[i]=elements[i];         //c2*(index)
            }
            int a=index;                      //c3
            for(int j=index+1; j<size;j++){
                nuevo[a]=elements[j];         //c4*(n-index)
                a++;
            }
            elements = nuevo;         //c6
            size--;                   //c7
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }                             //complejidad: O(index+n-index)= O(n)
    }                                 //donde n es la longitud de elements

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < size-1; i++) {
            cadena = cadena+ elements[i]+ " ,";
        }
        cadena+=elements[size-1];
        
        return "["+cadena+"]";
    }   
}
