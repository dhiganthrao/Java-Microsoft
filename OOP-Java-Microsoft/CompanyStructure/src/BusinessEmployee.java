abstract public class BusinessEmployee extends Employee {

    public double budget;

    public BusinessEmployee(String name) {
        super(name, 50000);
        budget = 0;
    }

    public double getBonusBudget() {
        return budget;
    }

    public String employeeStatus() {
        return (this.ID + " " + this.EmployeeName + " with a budget of " + budget);
    }

    abstract public void Parking();
}