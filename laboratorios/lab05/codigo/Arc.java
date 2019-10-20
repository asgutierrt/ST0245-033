package Laboratorio5;

/**
 * Class representing the elements of an arc
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1.0
 */

public class Arc {
    private Vertex start, destination;
    private String name;
    private double distance;

    /**
     * Constructor method
     *
     * @param start
     * @param destination
     * @param name
     * @param distance
     */
    public Arc(Vertex start, Vertex destination, String name, double distance) {
        this.start = start;
        this.destination = destination;
        this.name = name;
        this.distance = distance;
    }

    /**
     * @return start Vertex
     */
    public Vertex getStart() {
        return start;
    }

    /**
     * @return destination vertex
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     * @return name of the arc
     */
    public String getName() {
        return name;
    }

    /**
     * @return distance of the arc
     */
    public double getDistance() {
        return distance;
    }

    /**
     * All attributes of the arc are printed
     */
    public void printArc() {
        System.out.print("ARC{Name:" + name + ", distance:" + distance + ", start vertex: " + start.getName() +
                "(Id: " + start.getId() + ")" + ", destination vertex: " + destination.getName() + "(Id:" + destination.getId() + ")}, ");
    }
}
