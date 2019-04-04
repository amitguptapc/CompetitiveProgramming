import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection implements Comparator<ActivitySelection.Activity> {

    static class Activity {
        int start;
        int end;

        public Activity(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int compare(Activity x, Activity y) {
        return x.end - y.end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Activity> a = new ArrayList<>();
            for (int i = 0; i < n; i++)
                a.add(new Activity(sc.nextInt(), sc.nextInt()));
            a.sort(new ActivitySelection());
            int count = 1;
            int j = 0;
            for (int i = 1; i < n; i++) {
                if (a.get(i).start >= a.get(j).end) {
                    count++;
                    j = i;
                }
            }
            System.out.println(count);
        }
    }
}