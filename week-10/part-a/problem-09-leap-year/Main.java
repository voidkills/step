// Part A Problem 9: Leap Year Detector (one year per line)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int y = sc.nextInt();
            boolean leap = (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
            System.out.println(leap ? "Leap year" : "Not a leap year");
        }
        sc.close();
    }
}
