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
public class Main {

    /**
     * @param args the command line arguments
     */
   
    public static boolean ejercicio1(){
	        int a,b,c,d;
	        a = Taller4.arrayMax(new int[] {12,324,43,2,3,43,2,3,43},8);
	        b = Taller4.arrayMax(new int[] {3,2,343,2,43,55,67,68,86,3,4},10);
	        c = Taller4.arrayMax(new int[] {56,7,6,45,8,4,34,8,7,5,34,7,78,9},13);
	        d = Taller4.arrayMax(new int[] {1,2,3,4,5,5},5);
	        if(a!=475 || b!=676 || c!=308 || d!=20)
	            return false;
	        return true;
	    }
	    
	    public static boolean ejercicio2(){
	    	boolean a, b, c, d;
			a=Taller4.groupSum(0, new int[] {2, 4, 8}, 9);
			b=Taller4.groupSum(0, new int[] {2, 4, 8}, 8);
			c=Taller4.groupSum(0, new int[] {10, 2, 2, 5}, 9);
			d=Taller4.groupSum(0, new int[] {10, 2, 2, 5}, 17);
			if(!a && b && c && d)
				return true;
			return false;
		}
	    
	
	    public static boolean ejercicio3(){
	       long a,b,c,d;
	       a = Taller4.fibonacci(4);
	       b = Taller4.fibonacci(8);
	       c = Taller4.fibonacci(12);
	       d = Taller4.fibonacci(16);
	       if(a==3 && b==21 && c==144 && d==987)
	    	   return true;
	       return false;
	    }
            
	    
	    public static void main(String[] args){
	        //Ejercicio1
	        if(ejercicio1())
	            System.out.println("Ejercicio 1 Correcto");
	        else
	        System.out.println("Ejercicio 1 Incorrecto");
	        
                int [] a= new int[] {12,324,43,2,3,43,2,3,43,3,2,343,2,43,55,67,68,86,3,4,56,7,6,45,8,4,34,8,7,5,34,7,78,9,
                1,2,3,4,5,5,12,324,43,2,3,43,2,3,43,3,2,343,2,43,55,67,68,86,3,4,56,7,6,45,8,4,34,8,7,5,34,7,78,9,
                1,2,3,4,5,5,12,324,43,2,3,43,2,3,43,3,2,343,2,43,55,67,68,86,3,4,56,7,6,45,8,4,34,8,7,5,34,7,78,9,
                1,2,3,4,5,5,12,324,43,2,3,43,2,3,43,3,2,343,2,43,55,67,68,86,3,4,56,7,6,45,8,4,34,8,7,5,34,7,78,9,
                1,2,3,4,5,5};
		for (int i =100; i<160; i++) {
		    int[] b = new int[i];
		    int k = 0;
		    for (int j = 0; j < i; j++) {
			b[j] = a[k];
			k++;
		    }
		    long start = System.currentTimeMillis();
		    int w = Taller4.arrayMax(b, b.length-1);
		    long exit = System.currentTimeMillis();
		    long time = exit - start;
		    System.out.println(time);
		}
                
	      //Ejercicio2
	        if(ejercicio2())
	            System.out.println("Ejercicio 2 Correcto");
	        else
	        System.out.println("Ejercicio 2 Incorrecto");
	        
                for (int i =16; i<26; i++) {
		    int[] b = new int[i];
		    int k = 0;
		    for (int j = 0; j < i; j++) {
			b[j] = a[k];
			k++;
		    }
		    long start = System.currentTimeMillis();
		    boolean w = Taller4.groupSum(0, b , 8);
		    long exit = System.currentTimeMillis();
		    long time = exit - start;
		    System.out.println(time);
		}
                
	        
	        //Ejercicio3
	        if(ejercicio3())
	            System.out.println("Ejercicio 3 Correcto");
	        else
	        System.out.println("Ejercicio 3 Incorrecto");
                
           //Ciclo de determina el tiempo en milisegundos dado un n (n está en el intervalo [30,49])
              for (int i = 30; i < 50 ; i++) {
           	 long start = System.currentTimeMillis();
            	long a = Taller4.fibonacci(i);
            	long exit = System.currentTimeMillis();
            	long time = exit - start;
            	System.out.println(time);
              }
             
                
	    }
   
    
}