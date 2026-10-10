// Problem 8: Duty Roster Rotation
// Time: O(n), Space: O(n) for the result.
// k % n drops full turns first. Rotating one place at a time, k times, costs
// O(n * k) -- with k up to 10^9 that never finishes; this is O(n) always.
import java.util.*;

public class Main {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n); // effective right rotation
        String[] out = new String[n];
        for (int i = 0; i < n; i++) out[(i + shift) % n] = names[i];
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        long k = sc.nextLong();
        System.out.println("[" + String.join(", ", rotateRoster(names, k)) + "]");
        sc.close();
    }
}
