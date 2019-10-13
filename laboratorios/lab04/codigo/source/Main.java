package Laboratorio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> informationLines = Files.readFIle(); //  Read file
        Files.printList(informationLines);
        Operations.toAssign(informationLines);
    }
}
