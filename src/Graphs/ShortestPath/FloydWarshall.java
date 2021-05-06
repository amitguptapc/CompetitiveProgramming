import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// all pair shortest path algorithm
// Complexity O(V^3)
public class FloydWarshall {
    int[][] graph, dist, next;
    int v, INF = Integer.MAX_VALUE;

    FloydWarshall(int v) {
        this.v = v;
        graph = new int[v][v];
        dist = new int[v][v];
        next = new int[v][v];
        for (int i = 0; i < v; i++) {
            Arrays.fill(graph[i], INF);
            Arrays.fill(dist[i], INF);
            Arrays.fill(next[i], -1);
        }
        for (int i = 0; i < v; i++) {
            graph[i][i] = 0;
            dist[i][i] = 0;
        }
    }

    void addEdge(int u, int v, int w) {
        graph[u][v] = w;
        dist[u][v] = w;
        next[u][v] = v;
    }

    void getAPSP() { // get All Pair Shortest Path
        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
    }

    void print(int[][] a) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (a[i][j] != INF)
                    System.out.print(a[i][j] + "\t");
                else System.out.print("∞\t");
            }
            System.out.println();
        }
    }

    List<Integer> getPath(int u, int v) {
        if (next[u][v] == -1)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (u != v) {
            u = next[u][v];
            list.add(u);
        }
        return list;
    }

    void printAllPath() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j)
                    continue;
                System.out.print("Shortest Path between " + i + " and " + j + " is : ");
                List<Integer> path = getPath(i, j);
                if (path.size() == 0)
                    System.out.println("No Path Exists");
                else {
                    System.out.print(i);
                    for (int l : path)
                        System.out.print(" -> " + l);
                    System.out.println(" with cost " + dist[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        FloydWarshall g = new FloydWarshall(v);
        while (e-- > 0)
            g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        g.getAPSP();
        System.out.println("Graph is :");
        g.print(g.graph);
        System.out.println("All Pair Shortest Path length are :");
        g.print(g.dist);
        System.out.println("All Pair Shortest Path are :");
        g.printAllPath();
    }
}

/*
4
6
0 3 2
3 0 1
0 1 5
2 3 1
3 1 -2
1 2 3
 */
