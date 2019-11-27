import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BreadthFirstSearch {


    public static ArrayList<Arc> generateTree(Graph graph, int source) {
        int last;
        Parcours parcours = new Parcours(graph);

        parcours.algo(graph, 0);

        //findLastArc(parcours);


        return parcours.algo(graph, source);
    }

    public static int findLastArc(Parcours parcours){
        List<Integer> integers = new LinkedList<>();

        for (int index=0; index<parcours.predecessor.size(); index++){
            if (parcours.predecessor.get(index).haveDest()) integers.add(index);
        }

        return new Random().nextInt(integers.size());
    }

}
