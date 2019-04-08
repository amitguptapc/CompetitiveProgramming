package src.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder<T> extends Graph<T> {
    public static void main(String[] args) {

        // board of size 6 x 6
        int[] board = new int[37];

        // for ladders
        board[2] = 13;
        board[5] = 2;
        board[9] = 18;
        board[18] = 11;

        // for snakes
        board[17] = -13;
        board[20] = -14;
        board[24] = -8;
        board[25] = -10;
        board[32] = -2;
        board[34] = -22;

        // draw the graphical structure of the board
        SnakeAndLadder<Integer> g = new SnakeAndLadder<>();
        for (int u = 1; u <= 36; u++) {

            // for every possible outcome of the dice
            for (int dice = 1; dice <= 6; dice++) {

                // destination is source + dice outcome + effect of snake or ladder
                if (dice + u <= 36) {
                    int v = u + dice + board[u + dice];
                    g.addEdge(u, v, false);
                }
            }
        }
        System.out.println("Minimum moves required is : " + g.minDistance(1, 36));
    }

    private int minDistance(T src, T dest) {
        Queue<T> q = new LinkedList<>();
        Map<T, Integer> distance = new HashMap<>();
        Map<T, T> parent = new HashMap<>();
        for (T node : adjList.keySet())
            distance.put(node, Integer.MAX_VALUE);
        q.add(src);
        distance.put(src, 0);
        while (!q.isEmpty()) {
            T node = q.poll();
            for (T neighbour : adjList.get(node)) {
                if (distance.get(neighbour) == Integer.MAX_VALUE) {
                    q.add(neighbour);
                    distance.put(neighbour, distance.get(node) + 1);
                    parent.put(neighbour, node);
                }
            }
        }

        // printing the path of victory
        T ptr = dest;
        while (ptr != src) {
            System.out.print(ptr + " <- ");
            ptr = parent.get(ptr);
        }
        System.out.println(src);

        // return the no of steps required to win
        return distance.get(dest);
    }
}
