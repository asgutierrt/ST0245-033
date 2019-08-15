package taller5;

public class Taller5 {

    /**
    * @param array es una arreglo de numeros enteros.
    * El m�todo suma tiene la intenci�n de hacer el proceso de suma
    * mediante una funcion c�clica (while/for/...)
    * @return la suma de todos los numeros sumados.
    */
    public static int suma (int[]array){
        int suma =0;                           //c_1
        for (int i=0; i<array.length; i++){    //c_2*n + c_3
         suma += array[i];
        }
        return suma;
    }
    
    
    /**
    * @param num es el numero el cual se utiliza para ser multiplicado.
    * El m�todo mul tiene la intenci�n de hacer la multiplicaci�n
    * de 1 a n por el numero mul
    * mediante una funcion c�clica (while/for/...)
    * 
    */
    public static void mul (int num){
      //...
    }
    
    
    /**
    * @param array es un arreglo de n�meros desordenados
    * El m�todo insertionSort tiene la intenci�n ordenar los n�meros
    * del arreglo array por el m�todo insertion:
    * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
    * mediante la anidaci�n de funciones c�clicas (while/for/...)
    * 
    */
    public static int [] insertionSort (int [] a){
        for (int i = 1; i < a.length; i++) {
            int auxiliar = a[i];
            int j = i-1;
            while(a[i]<a[j]){
                int temporal = a[j];
                a[j] =auxiliar;
                a[i] = temporal;
                i--;
                j--;
                if(j==-1 || i==-1)break;
            }
            
        }
        return a;
    } 
    
}