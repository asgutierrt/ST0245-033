package Laboratorio4;

import java.util.ArrayList;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */

public class Directory {
    private String user, name, size;
    ArrayList<Directory> directories = new ArrayList<>();
    ArrayList<FileUsers> files = new ArrayList<>();

    /**
     * Constructor method
     *
     * @param user
     * @param name
     * @param size
     */
    public Directory(String user, String name, String size) {
        this.user = user;
        this.name = name;
        this.size = size;
        this.directories = directories;
        this.files = files;
    }

    /**
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return listDirectories
     */
    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    /**
     * @return listFiles
     */
    public ArrayList<FileUsers> getFiles() {
        return files;
    }

    public void printDirectories(){
        System.out.println("USER: "+ getUser());
        System.out.println("NAME: "+ getName());
        System.out.println("SIZE: "+ getSize());
        System.out.println("DIRECTORIES: "+ getDirectories().toString());
        System.out.println("FILES: "+ getFiles());
    }

    @Override
    public String toString() {
        return name;
    }
}
