// Minimize total cash flow among friends
public class MinimumCashFlow {
    public static void minCashFlow(int[] amount, int n) {
        // find the people with max and min amounts
        int maxDebtor = 0, maxCreditor = 0;
        for (int i = 0; i < n; i++) {
            if (amount[maxDebtor] > amount[i])
                maxDebtor = i;
            if (amount[maxCreditor] < amount[i])
                maxCreditor = i;
        }

        // when all cash is settled
        if (amount[maxCreditor] == 0 && amount[maxDebtor] == 0)
            return;

        int min = Math.min(-amount[maxDebtor], amount[maxCreditor]);
        amount[maxCreditor] -= min;
        amount[maxDebtor] += min;

        System.out.println(maxDebtor + " pays " + min + " to " + maxCreditor);

        minCashFlow(amount, n);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] txns = { // txns[i][j] : amount i needs to pay j
                {0, 1000, 2000},
                {450, 0, 5000},
                {200, 1500, 0}
        };

        int[] amount = new int[n]; // find net amount to be paid to person i
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                amount[i] += txns[j][i] - txns[i][j];
        minCashFlow(amount, n);
    }
}