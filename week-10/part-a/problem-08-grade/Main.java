// Part A Problem 8: Student Grade Assignment (one mark per line)
import java.util.*;

public class Main {
    static char grade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println("Grade " + grade(sc.nextInt()));
        }
        sc.close();
    }
}
