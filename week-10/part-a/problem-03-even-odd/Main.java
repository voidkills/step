// Part A Problem 3: Even and Odd Numbers in a List (accepts "[3, 8, ...]" form)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[^0-9\\- ]", " ").trim();
        int even = 0, odd = 0;
        if (!line.isEmpty()) {
            for (String t : line.split("\\s+")) {
                if (Integer.parseInt(t) % 2 == 0) even++;
                else odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
