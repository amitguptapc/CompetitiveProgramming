import java.util.ArrayList;
import java.util.HashMap;

public class CycleInDirectedGraph<T> extends src.Graphs.Graph<T> {
    private boolean isCyclicHelper(T node, HashMap<T, Boolean> stack, ArrayList<T> visited) {
        visited.add(node);
        stack.put(node, true);
        for (T nbr : adjList.get(node)) {
            if (stack.containsKey(nbr) && stack.get(nbr))
                return true;
            if (!visited.contains(nbr))
                return isCyclicHelper(nbr, stack, visited);
        }
        stack.put(node, false);
        return false;
    }

    private boolean isCyclic() {
        HashMap<T, Boolean> stack = new HashMap<>();
        ArrayList<T> visited = new ArrayList<>();
        boolean ans = false;
        for (T node : adjList.keySet()) {
            if (!visited.contains(node))
                ans = ans || isCyclicHelper(node, stack, visited);
        }
        return ans;
    }

    /*
    If while traversing any visited node is encountered, which
    is also in the current call stack, there exists a cycle
    */

    public static void main(String[] args) {
        CycleInDirectedGraph<Integer> g = new CycleInDirectedGraph<>();
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 1, false);
        System.out.println("Cycle is present : " + g.isCyclic());
    }
}