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
public class Taller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(1, 8, 2017);
        System.out.println(f1);
        System.out.println(f2);
        // 1
        System.out.println(f1.comparar(f2));
        
    }
    
}
