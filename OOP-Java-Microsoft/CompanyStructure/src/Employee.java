abstract public class Employee {
    String EmployeeName;
    double BaseSalary;
    static int count;
    int ID;
    double bonus;
    double budget;
    Employee manager;

    public Employee(String name, double baseSalary) {
        this.EmployeeName = name;
        this.BaseSalary = baseSalary;
        count++;
        ID = count;

    }

    public double getBaseSalary() {
        return BaseSalary;
    }

    public String getName() {
        return EmployeeName;
    }

    public int getEmployeeID() {
        return this.ID;
    }

    public Employee getManager() {
        return manager;

    }
    abstract public void Parking();

    public boolean equals(Employee other) {
        return this.ID == other.ID;
    }

    public String toString() {
        return (this.ID + " " + this.EmployeeName);
    }

    abstract public String employeeStatus();


}


