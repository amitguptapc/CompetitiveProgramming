import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.spoj.com/problems/BUSYMAN/
public class Busyman implements Comparator<Busyman.Event> {
    static class Event {
        int start;
        int end;

        Event(int s, int e) {
            start = s;
            end = e;
        }
    }

    @Override
    public int compare(Event o1, Event o2) {
        return o1.end - o2.end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Event[] a = new Event[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Event(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(a, new Busyman());
            int r = 1;
            int req = a[0].end;
            for (int i = 1; i < n; i++) {
                if (a[i].start >= req) {
                    req = a[i].end;
                    r++;
                }
            }
            System.out.println(r);
        }
    }
}