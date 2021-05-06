package Recursion_N_Backtracking_Challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumTimeTraversal {
    static class Pipeline {
        int sx, sy, ex, ey;
        int time;

        Pipeline(int a, int b, int c, int d, int t) {
            this.sx = a;
            this.sy = b;
            this.ex = c;
            this.ey = d;
            this.time = t;
        }
    }

    private static long minTime;
    private static Pipeline[] pipes;
    private static int sx, sy, ex, ey;

    private static void swap(ArrayList<Integer> lis, int i, int j) {
        int a = lis.get(i);
        int b = lis.get(j);
        lis.set(i, b);
        lis.set(j, a);
    }

    private static void orderPipelines(ArrayList<Integer> lis, int i, int n) {
        if (i == n) {
            long time = 0;
            int m = lis.size();
            if (m == 0) {
                time = Math.abs(sx - ex) + Math.abs(sy - ey);
            } else {
                time += Math.abs(pipes[lis.get(0)].sx - sx) + Math.abs(pipes[lis.get(0)].sy - sy);
                for (int x = 0; x < m; x++) {
                    time += pipes[lis.get(x)].time;
                    if (x < m - 1)
                        time += Math.abs(pipes[lis.get(x)].ex - pipes[lis.get(x + 1)].sx) + Math.abs(pipes[lis.get(x)].ey - pipes[lis.get(x + 1)].sy);
                }
                time += Math.abs(pipes[lis.get(m - 1)].ex - ex) + Math.abs(pipes[lis.get(m - 1)].ey - ey);
            }
            minTime = Math.min(time, minTime);
            return;
        }
        for (int x = i; x < n; x++) {
            swap(lis, i, x);
            orderPipelines(lis, i + 1, n);
            swap(lis, i, x);
        }
    }

    private static void selectPipelines(ArrayList<Integer> lis, int i, int n) {
        if (i == n) {
            orderPipelines(lis, 0, lis.size());
            return;
        }
        lis.add(i);
        selectPipelines(lis, i + 1, n);
        lis.remove(lis.size() - 1);
        selectPipelines(lis, i + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            sx = sc.nextInt();
            sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();
            pipes = new Pipeline[2 * n];
            int p, q, r, s, ti;
            for (int i = 0; i < n; i++) {
                p = sc.nextInt();
                q = sc.nextInt();
                r = sc.nextInt();
                s = sc.nextInt();
                ti = sc.nextInt();
                pipes[i] = new Pipeline(p, q, r, s, ti);
                pipes[2 * n - i - 1] = new Pipeline(r, s, p, q, ti); // to reverse stat and end for each pipeline
            }
            minTime = Long.MAX_VALUE;
            selectPipelines(new ArrayList<>(), 0, 2 * n);
            System.out.println("#" + c++ + " : " + minTime);
        }
    }
}
