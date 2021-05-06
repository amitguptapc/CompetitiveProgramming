package Recursion_N_Backtracking;

// https://codeforces.com/problemset/problem/812/B

import java.util.Scanner;

public class SagheerHausmeister {
    private static int ans = Integer.MAX_VALUE;
    private static int m;
    private static int[] maxDistFromRight, maxDistFromLeft;
    private static int maxFloor = -1;

    private static void minTimeReq(char enterFrom, int floorNo, int time) {
        if (floorNo == maxFloor) { // top floor is reached
            if (enterFrom == 'L')
                ans = Math.min(ans, time + maxDistFromLeft[floorNo]);
            if (enterFrom == 'R')
                ans = Math.min(ans, time + maxDistFromRight[floorNo]);
            return;
        }
        if (enterFrom == 'L') {
            minTimeReq('L', floorNo + 1, time + 2 * maxDistFromLeft[floorNo] + 1);
            minTimeReq('R', floorNo + 1, time + m + 2);
        }
        if (enterFrom == 'R') {
            minTimeReq('L', floorNo + 1, time + m + 2);
            minTimeReq('R', floorNo + 1, time + 2 * maxDistFromRight[floorNo] + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        String[] building = new String[n];
        maxDistFromLeft = new int[n];
        maxDistFromRight = new int[n];
        for (int i = n - 1; i >= 0; i--) // reading in reverse order so that the ground floor comes on top
            building[i] = sc.next();
        for (int i = 0; i < n; i++) { // for iterating over n floors
            for (int j = 0; j < m + 2; j++) {
                if (building[i].charAt(j) == '1')
                    maxDistFromLeft[i] = Math.max(maxDistFromLeft[i], j);
                if (building[i].charAt(m + 1 - j) == '1')
                    maxDistFromRight[i] = Math.max(maxDistFromRight[i], j);
            }
            if (maxDistFromLeft[i] != 0)
                maxFloor = i;
        }
        if (maxFloor == -1) { // All lights are off
            System.out.println(0);
            return;
        }
        if (maxFloor == 0) { // Lights are on in ground floor only
            System.out.println(maxDistFromLeft[0]);
            return;
        }
        minTimeReq('L', 1, 2 * maxDistFromLeft[0] + 1);
        minTimeReq('R', 1, m + 2);
        System.out.println(ans);
    }
}
