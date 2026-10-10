// Problem 3: College Fee Counter
// Design: abstract Student owns what every student has (name + a tuition
// rule). "Uses the college bus?" is a separate ability, so the transport fee
// lives once in the BusUser interface, implemented only by DayScholar and
// Scholar. The counter checks instanceof BusUser -- never the student type
// by name -- so adding/removing bus usage never touches other types.
import java.util.*;

abstract class Student {
    final String name;

    Student(String name) { this.name = name; }

    abstract double tuition();
}

// One place for the bus fee; only bus users implement this.
interface BusUser {
    double TRANSPORT_FEE = 12000.0;
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }
    @Override double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    @Override double tuition() { return 40000 + 60000; }
}

class ScholarStudent extends Student implements BusUser {
    ScholarStudent(String name) { super(name); }
    @Override double tuition() { return 20000; }
}

public class Main {
    static Student studentFor(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarStudent(name);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+", 2);
            Student s = studentFor(parts[0], parts[1]);
            double fee = s.tuition() + (s instanceof BusUser ? BusUser.TRANSPORT_FEE : 0.0);
            total += fee;
            System.out.printf("%s: %.2f%n", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
