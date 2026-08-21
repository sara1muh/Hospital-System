
package hotelbookingsystem;

public class Room {
private int roomNumber;
private boolean isReserved;


    public Room(int roomNumber, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
     
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber=" + roomNumber + ", isReserved=" + isReserved + '}';
    }

   

public void RoomReserve(){
  isReserved =true;
}
public void RoomRelease(){
  isReserved =false;
}
}
