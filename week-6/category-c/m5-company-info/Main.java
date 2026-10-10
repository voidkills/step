// M5. Employee and Company Information Management — companyName and
// employeeCount are static (one shared copy); printCompanyInfo() touches
// no instance field and is called through the class name.
class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Main {
    public static void main(String[] args) {
        new Employee("Asha", 50000);
        new Employee("Ravi", 60000);
        new Employee("Neha", 55000);
        Employee.printCompanyInfo();
    }
}
