package hotel_reservation_system;
import java.util.Scanner;

public class Hotel_reservation_system {
	static int num_rooms = 0;
	static Reservation [] reservations = new Reservation[5];
	
	static public void displayInfo() {
		for(int i = (num_rooms-1); i >= 0; i--)
		{
			System.out.printf("%s room reservation for %s starts on %s %d and ends on %s %d.\n",reservations[i].getRoomType(), 
					reservations[i].getHotelName(), 
					reservations[i].getReservationMonth(),
					reservations[i].getReservationStart(), 
					reservations[i].getReservationMonth(), 
					reservations[i].getReservationEnd());
		
			System.out.printf("Reservation has total cost of $%d.\n\n",reservations[i].calculateTotalPrice(reservations[i].getDailyCost(), 
					reservations[i].getReservationStart(), 
					reservations[i].getReservationEnd()));
			
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.printf("1. Create new Reservation\n");
			System.out.printf("2. Display all Reservations\n");
			System.out.printf("0. Exit\n");
			selection = scanner.nextInt();
			scanner.nextLine();
			
			switch(selection) {
				case 1:
					System.out.printf("Hotel Name: ");
					String name = scanner.nextLine();
					
					System.out.printf("\nReservation Month: ");
					String month = scanner.nextLine();
					
					System.out.printf("\nReservation Start: ");
					int start = scanner.nextInt();
					scanner.nextLine();
					
					System.out.printf("\nReservation End: ");
					int end = scanner.nextInt();
					scanner.nextLine();
					
					System.out.printf("\nDaily Cost: ");
					int cost = scanner.nextInt();
					scanner.nextLine();
					
					System.out.printf("\nRoom Type: ");
					Reservation.RoomType type = Reservation.RoomType.valueOf(scanner.nextLine());
					
					System.out.printf("\nReservation Created!\n");
					Reservation res1 = new Reservation(name,month,start,end,cost,type);
					reservations[num_rooms] = res1;
					num_rooms++;
					break;
				case 2:
					displayInfo();
					break;
				case 0:
					break;
				default:
			}
		}
		while(selection != 0);
		scanner.close();
	}
}

