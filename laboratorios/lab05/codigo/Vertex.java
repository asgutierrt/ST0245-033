package Laboratorio5;

/**
 * Class representing a vertex
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1.0
 */
public class Vertex {
   private String name;
   private int id;
    private double x, y;

    /**
     * Constructor method
     *
     * @param id is vertex identification
     * @param name is the name of the vertex
     * @param x is the coordinate on the x axis
     * @param y is the coordinate on the y axis
     */
    public Vertex(int id, String name, double x, double y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return id of the vertex
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name of the vertex
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return coordinate x
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return coordinate y
     */
    public double getY() {
        return y;
    }

    /**
     * All attributes of the vertex are printed
     */
    public void printVertex(){
        System.out.println("VERTEX:{Name: "+name+", ID: "+id+", x: "+x+", y: "+y+"}");
    }
}
