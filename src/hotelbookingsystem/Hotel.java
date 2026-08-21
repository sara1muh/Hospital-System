
package hotelbookingsystem;

import java.util.ArrayList;
import java.util.Scanner;
public class Hotel {
 Scanner scanner =new Scanner(System.in);
 private SinglyLinkedList<Room> Rooms;
 private LLQueue<Guest> GuestLine;
 private ArrayList<Reservation>  reservations;

    public Hotel() {
    Rooms=new SinglyLinkedList<>();
    GuestLine=new LLQueue<>();
    reservations=new ArrayList<>();
    }

    public SinglyLinkedList<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(SinglyLinkedList<Room> Rooms) {
        this.Rooms = Rooms;
    }

    public LLQueue<Guest> getGuestLine() {
        return GuestLine;
    }

    public void setGuestLine(LLQueue<Guest> GuestLine) {
        this.GuestLine = GuestLine;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    
public void addReservation(Room room, Guest guest){
 Reservation reservation = new Reservation(room, guest);
  reservations.add(reservation);
 room.RoomReserve();
  GuestLine.enqueue(guest);
    
}
 public void cancelReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            reservation.getRoom().RoomRelease();  
            System.out.println("Reservation for " + reservation.getGuest().getName() + " has been canceled.");
            int s = GuestLine.size();
    for(int i = 0;  i< s; i++ ) {
       Guest ele = GuestLine.dequeue();
      if(ele.getName()!=reservation.getGuest().getName())
       GuestLine.enqueue(ele);  
    }
        } else {
            System.out.println("Reservation not found.");
        }
         
 }
 public int getPositionInQueue(int id){
     int position=-1;
      int s = GuestLine.size();
    for(int i = 0;  i< s; i++ ) {
       Guest ele = GuestLine.dequeue();
       if(ele.getId()==id){
      position=i+1;
     }
     GuestLine.enqueue(ele);   
    
 }
  return position;
}
 
 public void removeByName(String Name){
   //if(reservations.contains(Name)){
      int s = GuestLine.size();
    for(int i = 0;  i< s; i++ ) {
       Guest ele = GuestLine.dequeue();
     if(!ele.getName().equals(Name)){
    GuestLine.enqueue(ele); 
        // System.out.println("Your Name is Not on The List");
     }else{      
         System.out.println("Your Name Has Been Removed");  
     }
 }
     System.out.println("Queue After:");
 displayGuest();

}
// }
 public int getTotalGuestsByStatus(String status){
  int count=0;
  int s = GuestLine.size();
    for(int i = 0;  i< s; i++ ) {
       Guest ele = GuestLine.dequeue();
      if(ele.getStatus()==status)
     count++;
    GuestLine.enqueue(ele);     
 }
    return count;
}
 public void updateRoom(){
 Scanner scanner = new Scanner(System.in);
     System.out.println("Enter room number");
 int roomNumber=scanner.nextInt();
SinglyLinkedList.Node<Room> current = Rooms.head;
 while (current != null) {
Room room = current.getElement();
if (room.getRoomNumber() == roomNumber) {
System.out.println("Is the room reserved? (true/false):"); 
boolean isReserved = scanner.nextBoolean();   
room.RoomRelease(); // Reset reservation status
room.RoomReserve(); // Set new reservation status if needed
System.out.println("Room " + roomNumber + " updated to type Reserved: " + isReserved);
return;
}
current = current.getNext();
}
 System.out.println("Room " + roomNumber + " not found.") ;   
 }
 
 
 public Room findRoom(int roomNumber) {
SinglyLinkedList.Node<Room> current = Rooms.head; // Start from the head of the list
while (current != null) {
Room room = current.getElement();
if (room.getRoomNumber() == roomNumber) { // Check if the room number matches
    return room;
 }
current = current.getNext(); // Move to the next node
}
return null; // Return null if the room is not found
}
public void reserveMultipleRooms() {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the number of rooms to reserve:");
int numRooms = scanner.nextInt();
System.out.println("Enter the room numbers (space-separated):");
int[] roomNumbers = new int[numRooms];
for (int i = 0; i < numRooms; i++) {
roomNumbers[i] = scanner.nextInt();
}
 for (int roomNumber : roomNumbers) {
// Traverse the linked list to find each room
SinglyLinkedList.Node<Room> current = Rooms.head;
boolean found = false;
while (current != null) {
Room room = current.getElement();
if (room.getRoomNumber() == roomNumber) {
found = true;
if (room.isIsReserved()) {
System.out.println("Room " + roomNumber + " is already reserved.");
} else {
room.RoomReserve();
System.out.println("Room " + roomNumber + " reserved successfully.");
}
break;
}
current = current.getNext();
}
if (!found) {
System.out.println("Room " + roomNumber + " does not exist.");
}
}
}
public void displayRooms() {
System.out.println("Rooms:");
Rooms.display();

}
public void displayGuest(){
    System.out.println("Guests:"); 
    GuestLine.display();
}
public void fill(){
   Room r1=new Room(1,false);
   Room r2 = new Room(2, false); 
   Room r3 = new Room(3, true);  
   Guest g1=new Guest("Check-in","Reem",1122);
   Guest g2 = new Guest("Check-out", "Ali", 1123);
   Guest g3 = new Guest("Check-in", "Sami", 1124);
  Reservation Res1=new Reservation (r1,g1) ;
   Reservation Res2 = new Reservation(r2, g2); 
   Reservation Res3 = new Reservation(r3, g3);
  reservations.add(Res1);
  reservations.add(Res2);
  reservations.add(Res3);
  GuestLine.enqueue(g1);
  GuestLine.enqueue(g2);
  GuestLine.enqueue(g3);
  Rooms.addLast(r3);
 Rooms.addLast(r2);
  Rooms.addLast(r1);
}
}
