/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neveras;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author asgutierrt
 */
public class Neveras {

    /**
     * @param args the command line arguments
     */
    public static void neverasxtienda(Queue<Solicitud> solicitudes, Stack<Nevera> almacen) {
        do {
            Solicitud solicitud = solicitudes.poll();
            for (int i = 0; i < solicitud.cant; i++) {
                System.out.println("La nevera " + almacen.pop().desc + " va a la tienda " + solicitud.tienda);
            }
        } while (solicitudes.peek() != null);
    }

    public static void main(String[] args) {
        Stack<Nevera> almacen = new Stack<>();
        almacen.push(new Nevera(3, "roja"));
        almacen.push(new Nevera(4, "amarilla"));
        almacen.push(new Nevera(8, "blanca"));
        almacen.push(new Nevera(9, "negra"));
        almacen.push(new Nevera(5, "azul"));
        almacen.push(new Nevera(1, "verde"));

        Queue<Solicitud> solicitudes = new LinkedList<Solicitud>();
        solicitudes.add(new Solicitud(3, "Haceb"));
        solicitudes.add(new Solicitud(2, "exito"));
        solicitudes.add(new Solicitud(1, "carulla"));
        neverasxtienda(solicitudes, almacen);
    }

}
