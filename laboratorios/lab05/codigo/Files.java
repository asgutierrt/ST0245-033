package Laboratorio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Management of data stored in the file
 *
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
        File file = new File("./src/Laboratorio5/mapa.txt");
        Scanner input = new Scanner(file);
        System.out.println(file.getAbsolutePath());
        int cont = 0; //counter to determine amount of data/lines
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
