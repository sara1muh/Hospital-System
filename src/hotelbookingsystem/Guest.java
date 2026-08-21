
package hotelbookingsystem;

public class Guest extends Person{
 private String status;

    public Guest(String status, String name, int id) {
        super(name, id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guest{" + "Name="+super.getName()+" ID="+super.getId()+" status=" + status + '}';
    }
 
}
