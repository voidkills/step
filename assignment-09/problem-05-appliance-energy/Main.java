// Problem 5: Home Appliance Energy Report
// Design: abstract Appliance owns what every appliance shares (its power
// rating + the units formula: power x hours / 1000, plus cost = units x 8).
// "Supports saver mode?" is a separate ability in the SaverCapable
// interface, implemented only by AC and Washer. The report asks
// "instanceof SaverCapable" -- no if-else chain over appliance names -- so a
// saver request on Fridge/TV is reported structurally.
import java.util.*;

abstract class Appliance {
    static final double RATE_PER_UNIT = 8.0; // one place
    final int powerWatts;

    Appliance(int powerWatts) { this.powerWatts = powerWatts; }

    abstract String label();

    // Shared by all appliances: units from this appliance's own rating.
    double units(double hours) { return powerWatts * hours / 1000.0; }

    double cost(double units) { return units * RATE_PER_UNIT; }
}

// Only appliances implementing this support saver mode.
interface SaverCapable {
    double SAVER_FACTOR = 0.75; // 25% reduction
}

class Fridge extends Appliance {
    Fridge() { super(150); }
    @Override String label() { return "FRIDGE"; }
}

class AirConditioner extends Appliance implements SaverCapable {
    AirConditioner() { super(1500); }
    @Override String label() { return "AC"; }
}

class Television extends Appliance {
    Television() { super(100); }
    @Override String label() { return "TV"; }
}

class Washer extends Appliance implements SaverCapable {
    Washer() { super(500); }
    @Override String label() { return "WASHER"; }
}

public class Main {
    static Appliance applianceFor(String name) {
        switch (name) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Television();
            case "WASHER": return new Washer();
            default: throw new IllegalArgumentException("Unknown appliance: " + name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Appliance a = applianceFor(p[0]);
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length > 2 && p[2].equals("SAVER");
            if (saver && !(a instanceof SaverCapable)) {
                System.out.printf("%s: saver mode not supported%n", a.label());
                continue;
            }
            double units = a.units(hours);
            if (saver) units *= SaverCapable.SAVER_FACTOR;
            double cost = a.cost(units);
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.label(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
