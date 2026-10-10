// Part A Problem 2: Word Reverser and Palindrome Checker (one word per line)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String word = sc.nextLine().trim();
            if (word.isEmpty()) continue;
            String reversed = new StringBuilder(word).reverse().toString();
            System.out.println(reversed + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
        }
        sc.close();
    }
}
