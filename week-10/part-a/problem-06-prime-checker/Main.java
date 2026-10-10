// Part A Problem 6: Prime Number Checker (trial division up to sqrt(n))
import java.util.*;

public class Main {
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long d = 2; d * d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
        }
        sc.close();
    }
}
