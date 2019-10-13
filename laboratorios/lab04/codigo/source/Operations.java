package Laboratorio4;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia GUtiérrez Tejada
 */

public class Operations {

    /**
     *
     * Search the path according to the data structure
     *
     * @param rawLIst
     */
    public static void toAssign(ArrayList<String> rawLIst) {
        Scanner input = new Scanner(System.in);
        Directory root = new Directory("Null", rawLIst.get(0), "NUll");
        rawLIst.remove(0);
        separate(root, rawLIst);
        System.out.println("AVAILABLE COMMANDS: ");
        System.out.println("List directories and files given a path: ");
        System.out.println("    ls <PATH>" + "  (If the name of a directory or file has spaces, change the space to '?')");
       // System.out.println("List files and directories smaller than one size given a path: ");
//        System.out.println("    lsl <PATH> <SIZE IN K>");
//        System.out.println("List files and directories larger than a given path: ");
//        System.out.println("    lsm <PATH> <SIZE IN K>");

        //
        System.out.print("Type command: ");
        String command = input.nextLine();

        String array[] = command.split(" ");
        String path[] = array[1].split("/");

        for (int i = 0; i < path.length; i++) {
            path[i] = path[i].replace("?", "");
        }
        Directory search = root;
        int s = 0;

        if (array.length == 2) {
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < search.directories.size(); j++) {
                    if (search.directories.get(j).getName().equals(path[i])) {
                        search = search.directories.get(j);
                        s++;

                    }
                }
            }
            if (s == path.length-1){
              if(s==0){
                  if(path[0].equals("Proyecto")){
                      search.printDirectories();
                  }else{
                      System.out.println("No such file or directory");
                  }

              }else{
                  search.printDirectories();
              }

            }else{
                System.out.println("No such file or directory");
            }

        }
    }


    /**
     * The data structure is created
     *
     * @param root   (Directory)
     * @param rwList (raw list)
     */
    public static void separate(Directory root, ArrayList<String> rwList) {
        for (int i = 0; i < rwList.size(); i++) {
            int base = 22;
            String line = rwList.get(i);
            int cd = -1;
            String array[] = line.split("]");
            int ll = array[0].length();

            String a[] = array[0].split("\\[");
            String b[] = a[1].split(" ");
            String user = b[0];
            String size = b[1];
            String name = array[1].replace(" ", "");

            if (array[0].length() == 22) {
                if (name.contains(".")) {
                    root.files.add(new FileUsers(user, name, size));
                    cd++;
                } else {
                    root.directories.add(new Directory(user, name, size));
                }
            } else {
                Directory aux = root;
                int cc = 0;
                while (base != ll) {
                    base += 4;
                    cc++;
                }
                for (int j = 0; j < cc; j++) {
                    root = root.directories.get(root.directories.size() - 1);
                }
                if (name.contains(".")) {
                    root.files.add(new FileUsers(user, name, size));
                    cd++;
                } else {
                    root.directories.add(new Directory(user, name, size));
                }

                root = aux;

            }
        }
    }
}
