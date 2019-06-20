import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BiasedStandings implements Comparator<BiasedStandings.Team> {
    @Override
    public int compare(Team o1, Team o2) {
        return o1.rank - o2.rank;
    }

    static class Team {
        String name;
        int rank;

        Team(String s, int r) {
            name = s;
            rank = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Team> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                int r = sc.nextInt();
                a.add(new Team(s, r));
            }
            a.sort(new BiasedStandings());
            long diff = 0;
            for (int i = 0; i < n; i++) {
                diff += Math.abs(i + 1 - a.get(i).rank);
            }
            System.out.println(diff);
        }
    }
}