package Dynamic_Programming.MultiDimensionalDP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JobForBounties2 {
    static class Job {
        long reward;
        int duration, deadline;

        Job(long a) {
            reward = a;
        }
    }

    private static long getMaxReward(int n, int t, Job[] jobs) {
        long[][] dp = new long[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (jobs[i - 1].duration <= j && jobs[i - 1].duration <= jobs[i - 1].deadline)
                    dp[i][j] = Math.max(
                            jobs[i - 1].reward + dp[i - 1][j - jobs[i - 1].duration],
                            dp[i - 1][j]
                    );
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][t];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Job(sc.nextLong());
        for (int i = 0; i < n; i++)
            jobs[i].duration = sc.nextInt();
        for (int i = 0; i < n; i++)
            jobs[i].deadline = sc.nextInt();
        Arrays.sort(jobs, Comparator.comparingInt(o -> o.deadline));
        System.out.println(getMaxReward(n, t, jobs));
    }
}
