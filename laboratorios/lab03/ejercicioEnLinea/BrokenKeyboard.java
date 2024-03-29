package Laboratorio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */
public class BrokenKeyboard {

    public static void main(String[] args) throws FileNotFoundException {

        String ruta = "./Keyboard.txt";
        File file = new File(ruta);
        Scanner input = new Scanner(file);

        int cont = 0; //counter to determine amount of data

        while (input.hasNext()) {
            String line = input.nextLine();
            System.out.println(process(line));
            cont++;
        }
    }

    /**
     * process the string according to the special commands
     * 
     * @param line
     * @return processed line
     */
    public static String process(String line) {
        LinkedList<Character> list = new LinkedList<>();
        String lineR = "";
        boolean start = false;
        int contAux = 0;

        for (int i = 0; i < line.length() - 1; i++) {
            do {
                if (line.charAt(i) == '[') {
                    start = true;
                    i++;
                    contAux = 0;
                }
                if (line.charAt(i) == ']') {
                    start = false;
                    contAux = 0;
                    i++;
                }
            } while (line.charAt(i) == '[' || line.charAt(i) == ']');

            if (start) {
                list.add(contAux, line.charAt(i));
                contAux++;
            } else {
                list.add(line.charAt(i));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            lineR += list.get(i);
        }
        return lineR;
    }

}
