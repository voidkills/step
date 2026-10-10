// Problem 1: Movie Ticket Counter
// Design: abstract Ticket owns everything every ticket shares (count + the
// single CONVENIENCE_FEE constant). Only the per-seat price varies, so it is
// an abstract price() overridden by each seat type. Ticket is abstract, so a
// plain "ticket" with no seat type can never be created or sold.
import java.util.*;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20.0; // one place only
    final int count;

    Ticket(int count) { this.count = count; }

    abstract double price();
    abstract String seat();

    double amount() { return count * price() + count * CONVENIENCE_FEE; }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }
    @Override double price() { return 150; }
    @Override String seat() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }
    @Override double price() { return 250; }
    @Override String seat() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }
    @Override double price() { return 400; }
    @Override String seat() { return "RECLINER"; }
}

public class Main {
    static Ticket ticketFor(String seat, int count) {
        switch (seat) {
            case "REGULAR": return new RegularTicket(count);
            case "PREMIUM": return new PremiumTicket(count);
            case "RECLINER": return new ReclinerTicket(count);
            default: throw new IllegalArgumentException("Unknown seat: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Ticket t = ticketFor(parts[0], Integer.parseInt(parts[1]));
            double amount = t.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", t.seat(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
