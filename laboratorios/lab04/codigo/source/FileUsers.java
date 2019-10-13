package Laboratorio4;

/**
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 */

public class FileUsers {
    private String user, name, size;

    /**
     * Constructor method
     *
     * @param user
     * @param name
     * @param size
     */
    public FileUsers(String user, String name, String size) {
        this.user = user;
        this.name = name;
        this.size = size;
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

    public void printFiles(){
        System.out.println("USER: "+getUser()+","+"NAME : "+ getName() + ", SIZE: "+getSize());
    }

    @Override
    public String toString() {
        return name;
    }
}
