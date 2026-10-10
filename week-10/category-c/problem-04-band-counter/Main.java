// Problem 4: Exam Score Band Counter
// Time: O(log n) per query (two binary searches). Space: O(1).
// Linear scan would be O(n) time per query -- too slow for frequent queries
// on n up to 10^6. Duplicates at the edges are handled by searching for
// boundaries (first >= low, first > high) instead of any single match.
import java.util.*;

public class Main {
    // First index with a[i] >= key.
    static int lowerBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // First index with a[i] > key.
    static int upperBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt(), high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}
