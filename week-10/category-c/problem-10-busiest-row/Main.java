// Problem 10: Busiest Bus Row
// Time: O(r * c) -- every seat visited once. Extra space: O(1).
// Strictly-larger update keeps the smallest index on ties.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < r; i++) {
            int total = 0;
            for (int j = 0; j < c; j++) total += sc.nextInt();
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        System.out.printf("Row %d, Total %d%n", bestRow, bestTotal);
        sc.close();
    }
}
