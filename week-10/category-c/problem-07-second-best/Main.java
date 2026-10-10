// Problem 7: Second-Best Score
// Time: O(n) one pass, no sorting. Space: O(1).
// Sorting first would cost O(n log n) time -- slower and needless.
// Skip scores equal to the current highest so duplicates never become "second".
import java.util.*;

public class Main {
    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second; // stays -1 when no distinct second score exists
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.println(secondHighest(scores));
        sc.close();
    }
}
