package Laboratorio5_2;

import java.util.Scanner;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
	    interaction();
    }

    /**
     * Handles user interaction
     */
    public static void interaction(){
        Scanner input = new Scanner(System.in);
        boolean a = true;
        while (a){
            System.out.print("Number of vertices: ");
            int numberVertices = input.nextInt();
            if(numberVertices==0){
                a = false;
                break;
            }
            System.out.print("Number of arches: ");
            int numberArches = input.nextInt();
            DigraphAM g = new DigraphAM(numberVertices);
            for (int i = 0; i<numberArches;i++){
                System.out.print("Type source: ");
                int source = input.nextInt();
                System.out.print("Type destination: ");
                int destination = input.nextInt();
                g.addArc(source,destination,1);
            }
            if(g.dfsHelper(0)){
                System.out.println("BICOLORABLE");
            }else{
                System.out.println("NOT BICOLORABLE");
            }
        }

    }
}
