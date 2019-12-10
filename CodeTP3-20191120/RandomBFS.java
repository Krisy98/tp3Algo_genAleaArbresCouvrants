import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomBFS {

    public static ArrayList<Arc> generateTree(Graph graph) {

        int source = new Random().nextInt(graph.order);

        ArrayList<Arc> tree = new ArrayList<>();
        List<Integer> waitingList = new LinkedList();
        List<Boolean> visited = new LinkedList<>();

        for (int index=0; index < graph.order; index++) visited.add(false);

        waitingList.add(source);
        visited.add(source, true);

        while (waitingList.size() != 0){

            int oneOfWaitingList = new Random().nextInt(waitingList.size());

            source = waitingList.get(oneOfWaitingList);
            waitingList.remove(oneOfWaitingList);

            for (int index=0; index < graph.outAdjacency.get(source).size(); index++){

                int destination = graph.outAdjacency.get(source).get(index).support.dest;

                if (destination == source) destination = graph.outAdjacency.get(source).get(index).support.source;

                if (!visited.get(destination).booleanValue()){
                    tree.add(graph.outAdjacency.get(source).get(index));
                    visited.set(destination, true);
                    waitingList.add(destination);
                }
            }
        }

        return tree;
    }



}
