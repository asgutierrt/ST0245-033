
import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
	

        private ArrayList<ArrayList<Pair<Integer,Integer>>> graph = new ArrayList<>(size); 
	/**
	* Constructor para el grafo dirigido
	* @param vertices el numero de vertices que tendra el grafo dirigido
	*
	*/
	public DigraphAL(int size) {
		super(size);
                ArrayList<Pair<Integer,Integer>> subgraph = new ArrayList<>();
                for (int i=0; i<size; i++){
                    graph.add(subgraph);
                }
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public void addArc(int source, int destination, int weight) {
            Pair element = new Pair(destination, weight);
            ArrayList<Pair<Integer,Integer>> subgraph = new ArrayList<>();
            subgraph.add(element);
            graph.add(source, subgraph);
        }

	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<Integer> getSuccessors(int vertex) {
            ArrayList<Integer> successors = new ArrayList<>();
                boolean empty = true;
                for (int i=0; i<graph.get(vertex).size();i++){
                    if(graph.get(vertex).size()!=0){
                        successors.add(graph.get(vertex).get(i).first);
                        empty = false;
                    }    
                }
                if (!empty ){
                    return successors; 
                }
                else{
                    return null;
                }
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
           
            for (int i=0; i<graph.get(source).size(); i++){
                if(graph.get(source).get(i).first == destination){
                    return graph.get(source).get(i).second;
                }
            }
            return 0;
	}
        

}