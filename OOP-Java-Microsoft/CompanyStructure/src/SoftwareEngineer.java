public class SoftwareEngineer extends TechnicalEmployee {

    boolean codeAccess;
    TechnicalLead manager;

    public void Parking() {

    }

    public SoftwareEngineer(String name) {
        super(name);
        codeAccess = false;

    }
    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return checkIn;
    }

    //need to double check the 2 next methods
    public boolean checkInCode() {
        if (manager.approveCheckIn(this)) {
            checkIn++;
            return true;
        }
        else {
            codeAccess = false;
            return false;
        }
    }
    public int checkIn() { return checkIn++; }
}
