package Laboratorio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class Files {

    /**
     * @return list with raw information
     * @throws FileNotFoundException
     */
    public static ArrayList<String> readFIle() throws FileNotFoundException {
        ArrayList<String> informationLines = new ArrayList<>();
        String ruta = "./src/Archivo/ejemplo.txt";
        File file = new File(ruta);
        Scanner input = new Scanner(file);
        System.out.println(file.getAbsolutePath());
        int cont = 0; //Contador para determinar cantidad de datos
        while (input.hasNext()) {
            String line = input.nextLine();
            informationLines.add(line);
            cont++;
        }
        return informationLines;
    }

    /**
     * A list is printed
     * @param list
     */
    public static void printList(ArrayList<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }
}