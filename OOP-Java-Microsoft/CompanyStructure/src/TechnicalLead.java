import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee {

    ArrayList<SoftwareEngineer> directReport = new ArrayList<>();
    int headCount;
    BusinessLead lead;
    Accountant support;

    public void Parking(){

    }


    public TechnicalLead(String name) {
        super(name);
        BaseSalary *= 1.3;
        headCount = 4;
    }

    public boolean hasHeadCount() {
        return (headCount >= directReport.size());
    }

    public boolean addReport(SoftwareEngineer e) {
        if (directReport.size() < headCount) {
            directReport.add(e);
            e.manager = this;
            return true;
        }
        return false;
    }
    public boolean approveCheckIn(SoftwareEngineer e) {
        if(e.manager == this && e.codeAccess == true) {
            return true;
        }
        else return false;
    }
    public String getTeamStatus() {
        if(this.directReport.size() == 0) {
            return(this.employeeStatus() + " and no direct reports yet.");
        }
        else {
            String text = "";
            text = text + employeeStatus();
            Iterator i = directReport.iterator();
            while(i.hasNext()) {
                text = text + "\n" + i.next();
            }
            return text;
        }
    }
}