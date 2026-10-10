// Part A Problem 7: Factorial Calculation (0! = 1)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            long fact = 1;
            for (long i = 2; i <= n; i++) fact *= i;
            System.out.println(fact);
        }
        sc.close();
    }
}
