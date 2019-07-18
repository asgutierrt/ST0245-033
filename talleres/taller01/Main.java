/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author SanHidalgo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Punto1
        Punto p = new Punto(-1, 1);
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Angulo Polar: " + p.distanciaEuclidiana(new Punto(1, 1)));

        System.out.println();
        
        //Punto2
        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(1, 8, 2017);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
        
        //Punto3
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i){
            if(i==4){
                c.incrementar(4);    //Incremento con cantidad diferente a 1
            }
            c.incrementar();
        }
        // 10
        System.out.println(c.incrementos());

        System.out.println(c.toString());
    }
    
}
