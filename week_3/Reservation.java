package hotel_reservation_system;
import java.util.Scanner;

public class Reservation {
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private int dailyCost;
	private RoomType roomType;
	public static int totalNumOfReservations = 0;
	
	static Reservation reservations[] = new Reservation[5];
	
	enum RoomType{
		Single,
		Double,
		Club,
		Family,
		Familywithview,
		Suite
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public int getDailyCost() {
		return dailyCost;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}

	Scanner scanner = new Scanner(System.in);

	public Reservation() {
		Reservation.totalNumOfReservations++;
		
		System.out.printf("Hotel Name: ");
		hotelName = scanner.nextLine();
		
		System.out.printf("\nReservation Month: ");
		reservationMonth = scanner.nextLine();
		
		System.out.printf("\nReservation Start: ");
		reservationStart = scanner.nextInt();
		scanner.nextLine();
		
		System.out.printf("\nReservation End: ");
		reservationEnd = scanner.nextInt();
		scanner.nextLine();
		
		roomType = RoomType.Single;
		
		System.out.printf("\nReservation Created!\n");
	}
	
	public Reservation(String type) {
		System.out.printf("ROOM INFOS: \n\nRoom Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false\n"
				+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false\n"
				+ "Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true\n"
				+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false\n"
				+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true\n"
				+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true\n");
		
		Reservation.totalNumOfReservations++;
		
		System.out.printf("Hotel Name: ");
		hotelName = scanner.nextLine();
		
		System.out.printf("\nReservation Month: ");
		reservationMonth = scanner.nextLine();
		
		System.out.printf("\nReservation Start: ");
		reservationStart = scanner.nextInt();
		scanner.nextLine();
		
		System.out.printf("\nReservation End: ");
		reservationEnd = scanner.nextInt();
		scanner.nextLine();
		
		System.out.printf("Room Type: ");
		roomType = RoomType.valueOf(scanner.nextLine());
		
		System.out.printf("\nReservation Created!\n");
	}
	
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost) {
		return(daily_cost*(reservation_end-reservation_start));
	}
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost, int multiplier) {
		return(multiplier * daily_cost*(reservation_end-reservation_start));
	}
	
	public static void total_num_room() {
		System.out.printf("%d Reservations created so far.\n",Reservation.totalNumOfReservations);
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void createReservation(){
        if(Reservation.totalNumOfReservations < reservations.length)
            reservations[Reservation.totalNumOfReservations] = new Reservation();
        else
            System.out.printf("There is no available room left.\n");
    }
	
	public static void createReservation(String type){
        if(Reservation.totalNumOfReservations < reservations.length)
            reservations[Reservation.totalNumOfReservations] = new Reservation(type);
        else
            System.out.printf("There is no available room left.\n");
    }
	
	////////////////////////////////////////////////////////////////////
	
	public static void display_info() {
		int i = 0;
		int price = 0;
		while(i<Reservation.totalNumOfReservations) {
			if(reservations[i].getReservationMonth().equals("June") 
				|| reservations[i].getReservationMonth().equals("July") 
				|| reservations[i].getReservationMonth().equals("August")) {
				price = calculate_total_price(reservations[i].getReservationStart(),reservations[i].getReservationEnd(),
						reservations[i].getDailyCost(),2);
			}
			else
				price = calculate_total_price(reservations[i].getReservationStart(),reservations[i].getReservationEnd(),
						reservations[i].getDailyCost());
		}

        System.out.printf("Reservation for a %s room in %s starts on %s %d and ends on %s\n", reservations[i].roomType,reservations[i].hotelName,reservations[i].reservationMonth,reservations[i].reservationStart,reservations[i].reservationEnd);
        System.out.printf("Reservation has total cost of $%d\n",price);
	}
}