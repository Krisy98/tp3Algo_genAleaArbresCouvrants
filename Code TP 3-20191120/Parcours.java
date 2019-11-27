import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Stack;


public class Parcours {

	Graph graph;
	Stack<Arc> frontier;	//pr etendre la zone : pile de sommets qui renvoit sur d'autre sommet nn atteint
	BitSet reached;		// déjà atteint
	ArrayList<Arc> predecessor;
	
	private void etendsFrontiere(int sommet) {
		for (Arc a : graph.outNeighbours(sommet))
			frontier.add(a);		// on add ts les voisins du sommet
	}
	
	
	private void explore(Arc a) {
		if (reached.get(a.getDest())){
			//predecessor.set(a.getDest(), a);
			return;	//s'il a deja ete atteint on fait r
		}
		reached.set(a.getDest());
		etendsFrontiere(a.getDest());
		predecessor.set(a.getDest(), a);
		predecessor.set(a.getSource(), a);

	}
	
	private void parcours(int source) {
		reached.set(source);		//on a atteint ce sommet
		etendsFrontiere(source);		//on met ts les voisins de la source
		while (!frontier.isEmpty())
			explore(frontier.pop());	//on enleve et renvoit la valeur
		
	}
	
	public Parcours(Graph graph) {
		this.graph = graph;
		this.frontier = new Stack<>();
		this.reached = new BitSet(graph.order);
		this.predecessor = new ArrayList<>(graph.order);
		for (int i = 0; i < graph.order; i++) {
			predecessor.add(null);
		}
	}
	

	public ArrayList<Arc> algo(Graph graph, int source) {
		Parcours p = new Parcours(graph);
		p.parcours(source);
		return p.predecessor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
