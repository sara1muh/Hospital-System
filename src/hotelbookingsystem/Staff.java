
package hotelbookingsystem;

public class Staff extends Person{
private String StaffRole;

    public Staff(String StaffRole, String name, int id) {
        super(name, id);
        this.StaffRole = StaffRole;
    }

    public String getStaffRole() {
        return StaffRole;
    }

    public void setStaffRole(String StaffRole) {
        this.StaffRole = StaffRole;
    }

}
