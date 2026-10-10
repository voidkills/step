// Problem 2: Parcel Shipping Desk
// Design: abstract Parcel answers "how much does shipping cost?" (charge())
// for every parcel. "Can it be insured?" is a separate question, so it lives
// in a separate Insurable interface implemented only by Express and Fragile.
// Making another type insurable later = just adding "implements Insurable",
// with zero changes to non-insured types. Fragile reuses Standard's charge.
import java.util.*;

abstract class Parcel {
    final double weightKg;
    final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double charge();
    abstract String type();
}

// Separate interface: only some parcels can be insured.
interface Insurable {
    double insurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    @Override double charge() { return 40 + 10 * weightKg; }
    @Override String type() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    @Override double charge() { return 80 + 15 * weightKg; }
    @Override public double insurance() { return 0.02 * declaredValue; }
    @Override String type() { return "EXPRESS"; }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    @Override double charge() { return super.charge() + 50; }
    @Override public double insurance() { return 0.02 * declaredValue; }
    @Override String type() { return "FRAGILE"; }
}

public class Main {
    static Parcel parcelFor(String type, double w, double v) {
        switch (type) {
            case "STANDARD": return new StandardParcel(w, v);
            case "EXPRESS": return new ExpressParcel(w, v);
            case "FRAGILE": return new FragileParcel(w, v);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Parcel parcel = parcelFor(p[0], Double.parseDouble(p[1]), Double.parseDouble(p[2]));
            double charge = parcel.charge();
            double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).insurance() : 0.0;
            double total = charge + insurance;
            grand += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}
