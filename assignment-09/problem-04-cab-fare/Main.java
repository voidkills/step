// Problem 4: City Cab Fare Meter
// Design: abstract Cab owns the rule shared by every cab (fare = distance x
// rate, never below MINIMUM_FARE) via the final baseFare() template method.
// "Can offer night service?" is a separate ability in the NightService
// interface, implemented only by Sedan and SUV -- so Mini night trips are
// rejected structurally, and a new cab type opts in by just implementing it.
import java.util.*;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0; // shared rule, one place
    final double rate;

    Cab(double rate) { this.rate = rate; }

    abstract String cab();

    // Template method: minimum-fare rule applies to every cab.
    final double baseFare(double km) { return Math.max(km * rate, MINIMUM_FARE); }
}

// Only cabs implementing this can run night trips.
interface NightService {
    double NIGHT_MULTIPLIER = 1.2;
}

class MiniCab extends Cab {
    MiniCab() { super(10); }
    @Override String cab() { return "MINI"; }
}

class SedanCab extends Cab implements NightService {
    SedanCab() { super(14); }
    @Override String cab() { return "SEDAN"; }
}

class SuvCab extends Cab implements NightService {
    SuvCab() { super(18); }
    @Override String cab() { return "SUV"; }
}

public class Main {
    static Cab cabFor(String cab) {
        switch (cab) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            case "SUV": return new SuvCab();
            default: throw new IllegalArgumentException("Unknown cab: " + cab);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Cab cab = cabFor(p[0]);
            double km = Double.parseDouble(p[1]);
            boolean night = p[2].equals("NIGHT");
            if (night && !(cab instanceof NightService)) {
                System.out.printf("%s: night service not available%n", cab.cab());
                continue;
            }
            double fare = cab.baseFare(km);
            if (night) fare *= NightService.NIGHT_MULTIPLIER;
            total += fare;
            System.out.printf("%s: %.2f%n", cab.cab(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
