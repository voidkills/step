// Part A Problem 4: In-Place Array Reversal (two pointers, no second list)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().replaceAll("[\\[\\]]", "").split(",");
        int[] a = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) a[i] = Integer.parseInt(tokens[i].trim());
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
        StringJoiner j = new StringJoiner(", ", "[", "]");
        for (int x : a) j.add(String.valueOf(x));
        System.out.println(j);
        sc.close();
    }
}
