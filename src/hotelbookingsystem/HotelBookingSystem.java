
package hotelbookingsystem;
import java.util.ArrayList;
import java.util.Scanner;
public class HotelBookingSystem {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Hotel h=new Hotel();
     int option = 0;
     h.fill();
do{
    System.out.println("--------------------------------------------------------");
    System.out.println("*****WLCOME TO OUR HOTEL*****"
            + "\n1.Create a Reservation"
            + "\n2.Cancle a Reservation"
            + "\n3.Position In Queue"
            + "\n4.Remove From Queue By Name"
            + "\n5.Total Checked in Guests"
            + "\n6.Find A Room"
            + "\n7.Update Room"
            + "\n8.Reserve Multiple Rooms"
            + "\n9.Exit"); 
    System.out.print("Pick A Number: ");
    option=input.nextInt();
    switch (option) {
        case 1:
     System.out.print("Enter room number: ");
  int resRoomNumber = input.nextInt();
    System.out.print("Enter guest ID: ");
  int resGuestId = input.nextInt();
  input.nextLine(); // Consume newline
    System.out.print("Enter guest name: ");
    String resGuestName = input.nextLine();
 Room resRoom = new Room(resRoomNumber, false); // Create new room
 Guest resGuest = new Guest( "Check in",resGuestName,resGuestId); // Create new guest
 h.addReservation(resRoom, resGuest); // Create reservation
 System.out.println("Reservation created for guest " + resGuestName + " with status: (checked in) in room number: " + resRoomNumber);
      break;
        case 2:
         System.out.print("Enter guest ID for reservation cancellation: ");
                    int cancelGuestId = input.nextInt();
                    Reservation toCancel = null;
                    for (Reservation reservation :h.getReservations() ) {
                        if (reservation.getGuest().getId()==cancelGuestId) {
                            toCancel = reservation;
                            break;
                        }
                    }
                    if (toCancel != null) {
                        h.cancelReservation(toCancel);
                    } else {
                        System.out.println("Reservation not found for guest ID: " + cancelGuestId);
                    }
                    break;
        case 3:
            System.out.println("enter your id:");
           int gId=input.nextInt();
           int a=h.getPositionInQueue(gId);
           if(a==-1){
               System.out.println("you are not in line");
           }else{
               System.out.println("Your Position is: "+a+" you have "+(a-1)+" people infront of you");  
           }
           break; 
        case 4:
            System.out.println("Enter Your Name:");
            String name=input.next();
            h.removeByName(name);
            
              break;
        case 5:
            System.out.println("Numbers  of Guests checked in are: "+h.getTotalGuestsByStatus("Check-in"));
            break;
        case 6:
            System.out.println("enter the room number to find");
int roomNumber = input.nextInt();
Room r=h.findRoom(roomNumber);
if(r!=null){
 System.out.println("room at "+r.getRoomNumber()+" reserved: "+r.isIsReserved());
}else{
System.out.println("room not found");
}
break;
        case 7:
h.updateRoom();
break;
        case 8:
           h.reserveMultipleRooms();
           break;
        case 9:
            System.out.println("Exiting The System"
                    + "\nThank you!!");
            break;
        default:
            System.out.println("Please pick a number from the list");;
    }
    }while(option!=9);
    }
    
}
