// Problem 6: Class Attendance Tracker
// Time: O(n) single pass -- both answers are found together. Space: O(1).
// Running streak grows on 1, resets on 0; best remembers its peak.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int present = 0, run = 0, best = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 1) {
                present++;
                run++;
                if (run > best) best = run;
            } else {
                run = 0;
            }
        }
        System.out.printf("Present: %d, Longest streak: %d%n", present, best);
        sc.close();
    }
}
