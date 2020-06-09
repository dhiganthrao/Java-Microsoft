public abstract class TechnicalEmployee extends Employee{
    int checkIn;

    public TechnicalEmployee(String TechnicalEmployeeName) {
        super(TechnicalEmployeeName,75000.0);
        checkIn = 0;
    }

    public String employeeStatus() {
        return (this.ID + " " + this.EmployeeName + " has " + checkIn + "successful check ins" + "\n");
    }

}
