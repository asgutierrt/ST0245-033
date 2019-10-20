package Laboratorio5;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that deals with the flow of data structure creation
 *
 * @author Santiago Hidalgo Ocampo
 * @author Ana Sofia Gutiérrez Tejada
 * @version 1.0
 */
public class Flow {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> information = Files.readFIle();
        HashMap<Integer, Vertex> mapVertex = createVertices(information);
        int idMax = getIdMax(mapVertex); // IdMax, size of the matriz.
        DigraphAM graph = new DigraphAM(idMax+1);
        fillGraph(graph,mapVertex, information); // The matrix is filled with the specified arcs
        graph.printMatrix(); // The graph (matrix) is printed with all its specifications (start, arrival, distance and names)
    }

    /**
     * @param information
     * @return vertex hashMap
     */
    public static HashMap<Integer, Vertex> createVertices(ArrayList<String> information) {
        HashMap<Integer, Vertex> mapVertex = new HashMap<Integer, Vertex>();
        information.remove(0);
        for (int i = 0; !information.get(i).contains("Arco"); i++) {
            String[] array = information.get(i).split(" ");
            String name = array[3];
            int id = Integer.parseInt(array[0]);
            double x = Double.parseDouble(array[1]);
            double y = Double.parseDouble(array[2]);
            mapVertex.put(id, new Vertex(id, name, x, y));
        }
        return mapVertex;
    }

    /**
     * @return idMax
     */
    public static int getIdMax(HashMap<Integer, Vertex> mapVertex) {
        int key = (int) mapVertex.keySet().toArray()[0];
        for (Integer keys : mapVertex.keySet()) { // ...
            if(key<keys){
                key=keys;
            }
        }
        return key;
    }

    /**
     * The matrix is filled with the specified arcs
     *
     * @param graph
     * @param map
     * @param information
     */
    public static void fillGraph(DigraphAM graph, HashMap<Integer, Vertex> map, ArrayList<String> information){
        // unnecessary information is removed (vertices)
        while (!information.get(0).contains("Arco")){
            information.remove(0);
        }
        information.remove(0);
        for (int i = 0; i <information.size() ; i++) {
            String[] array = information.get(i).split(" ");
            int id1 = Integer.parseInt(array[0]);
            int id2 = Integer.parseInt(array[1]);
            double distance = Double.parseDouble(array[2]);
            String name = array[3];
            for (int j = 4; j<array.length;j++){
                name+=array[j]+ " ";
            }
            Vertex start = map.get(id1);
            Vertex destination = map.get(id2);
            Arc arc = new Arc(start,destination,name,distance);
            graph.addArc(id1,id2,arc);
        }
    }
}
