// Part A Problem 5: Digit Sum and Number Reversal
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0, rev = 0, t = n;
        while (t > 0) {
            long d = t % 10;
            sum += d;
            rev = rev * 10 + d;
            t /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
        sc.close();
    }
}
