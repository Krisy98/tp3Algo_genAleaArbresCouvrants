import java.util.*;

public class AldousBroderAlgorithm {

    public static ArrayList<Arc> generateTree(Graph graph){

        ArrayList<Arc> tree = new ArrayList<>();
        List<Integer> visited = new LinkedList<>();

        int vertex = new Random().nextInt(graph.order);
        visited.add(vertex);

        while (visited.size() < graph.order){
            int aNeighbor;
            ArrayList<Integer> neighbors = new ArrayList<>();

            for (int index=0; index < graph.adjacency.get(vertex).size(); index++){
                Edge edge = graph.adjacency.get(vertex).get(index);

                if (edge.getDest() != vertex) neighbors.add(edge.getDest());
                else neighbors.add(edge.getSource());
            }

            aNeighbor = neighbors.get(new Random().nextInt(neighbors.size()));

            if (!visited.contains(aNeighbor)){
                Edge newEdge = new Edge(vertex, aNeighbor, 0);
                Arc newArc;

                if (graph.inAdjacency.get(vertex).contains(aNeighbor)) newArc = new Arc(newEdge, true);
                else newArc = new Arc(newEdge, false);

                visited.add(aNeighbor);

                tree.add(newArc);
            }
            vertex = aNeighbor;
        }
        return tree;
    }


}
