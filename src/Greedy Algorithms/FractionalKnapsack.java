import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack implements Comparator<FractionalKnapsack.Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return (int) (o2.cpw - o1.cpw); // descending order
    }

    static class Item {
        double price;
        double weight;
        double cpw;

        Item(double p, double w) {
            price = p;
            weight = w;
            cpw = price / weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] a = new Item[n];
        for (int i = 0; i < n; i++)
            a[i] = new Item(sc.nextDouble(), sc.nextDouble());
        double capacity = sc.nextDouble();
        double maxProfit = 0;
        Arrays.sort(a, new FractionalKnapsack());
        for (int i = 0; i < n; i++) {
            if (a[i].weight <= capacity) {
                maxProfit += a[i].price;
                capacity -= a[i].weight;
            } else {
                maxProfit += a[i].cpw * capacity;
                capacity = 0;
            }
        }
        System.out.println(maxProfit);
    }
}