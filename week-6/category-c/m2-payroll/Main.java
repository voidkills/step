// M2. Payroll Salary Management — private state, validated methods only;
// no public way to set basicSalary or bonus directly.
class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasic) {
        if (openingBasic < 0) {
            System.out.println("Warning: negative opening salary, starting at 0");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasic;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be positive");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be within 0-100");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        String shown = (percent % 1 == 0) ? String.valueOf((int) percent) : String.valueOf(percent);
        System.out.println("Tax deducted: " + shown + "%");
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}
