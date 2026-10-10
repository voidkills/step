// Part A Problem 10: Student Result Card Generator
// Input per student: Name [m1, m2, m3]. Grades: B for avg >= 75, D for
// 40..59 (per spec); A/C/F follow the same scale as Problem 8.
import java.util.*;

class Student {
    final String name;
    final int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    char grade() {
        double avg = average();
        if (avg >= 90) return 'A';
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String name = line.substring(0, line.indexOf(' '));
            String[] parts = line.replaceAll("[^0-9 ]", " ").trim().split("\\s+");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i]);
            Student s = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %c%n", s.name.toUpperCase(), s.average(), s.grade());
        }
        sc.close();
    }
}
