import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BreadthFirstSearch {

    public static ArrayList<Arc> generateTree(Graph graph, int source) {

        ArrayList<Arc> tree = new ArrayList<>();
        List<Integer> waitingList = new LinkedList();
        List<Boolean> visited = new LinkedList<>();

        for (int index=0; index < graph.order; index++) visited.add(false);

        waitingList.add(source);
        visited.add(source, true);

        while (waitingList.size() != 0){

            source = waitingList.get(0);
            waitingList.remove(0);

            for (int index=0; index < graph.outAdjacency.get(source).size(); index++){

                int destination = graph.outAdjacency.get(source).get(index).support.dest;

                if (!visited.get(destination)){
                    tree.add(graph.outAdjacency.get(source).get(index));
                    visited.set(destination, true);
                    waitingList.add(destination);
                }
            }
        }

        return tree;
    }


}
