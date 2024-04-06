package hotel_reservation_system;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

public class Reservation {
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private static int dailyCost;
	private RoomType roomType;
	public static int totalNumOfReservations = 0;
	static Reservation reservations[] = new Reservation[3];
	public static ArrayList<Reservation> reservationslist = new ArrayList<>(3);
	
	enum RoomType{
		Single,
		Double,
		Club,
		Family,
		Familywithview,
		Suite
	}
	
	////////////////////////////////////////////////////////////////////	
	
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
	
	public static void setDailyCost(int dailysCost) {
		dailyCost = dailysCost;
	}
	
	////////////////////////////////////////////////////////////////////

	

	public Reservation() {
		Reservation.totalNumOfReservations++;
		Scanner scanner = new Scanner(System.in);
		
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
		
		dailyCost = 100;
		
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
		Scanner scanner = new Scanner(System.in);
		
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
		
		System.out.printf("\nRoom Type: ");
		roomType = RoomType.valueOf(scanner.nextLine());
		Reservation.setDailyCost(Room.daily_cost);
		System.out.printf("\nReservation Created!\n");
	}
	
	////////////////////////////////////////////////////////////////////
	


	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost) {
		return(daily_cost*(reservation_end-reservation_start));
	}
	
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost, int multiplier) {
		return(multiplier * daily_cost*(reservation_end-reservation_start));
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void total_num_room() {
		System.out.printf("%d Reservations created so far.\n",Reservation.totalNumOfReservations);
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void createReservation(){
		if(Reservation.totalNumOfReservations < reservations.length) {
			Reservation reservation = new Reservation();
			reservations[Reservation.totalNumOfReservations-1] = reservation;
			reservationslist.add(reservation);
		}
    }
	
	public static void createReservation(String type){
		if(Reservation.totalNumOfReservations < reservations.length+1) {
			Reservation reservation = new Reservation(type);
			reservations[Reservation.totalNumOfReservations-1] = reservation;
			reservationslist.add(reservation);
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void display_info() {
		int price = 0;
		for(Reservation reservations : reservationslist) {
			if(reservations.getReservationMonth().equals("June") 
				|| reservations.getReservationMonth().equals("July") 
				|| reservations.getReservationMonth().equals("August")) {
				price = calculate_total_price(reservations.getReservationStart(),reservations.getReservationEnd(),
						reservations.getDailyCost(),2);
			}
			else
				price = calculate_total_price(reservations.getReservationStart(),reservations.getReservationEnd(),
						reservations.getDailyCost());
			
			System.out.printf("Reservation for a %s room in %s starts on %s %d and ends on %s\n", reservations.getHotelName()
	        		,reservations.getHotelName(), reservations.getReservationMonth(),
	        		reservations.getReservationStart(),reservations.getReservationEnd());
	        System.out.printf("Reservation has total cost of $%d\n\n",price);
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void list_city() {
		Scanner scanner = new Scanner(System.in);
		Reservation tmp;
		ListIterator <Reservation> resiter = reservationslist.listIterator();
		String city;
		System.out.printf("Type a city name for a reservation search: ");
		city = scanner.nextLine();
		while(resiter.hasNext()) {
			tmp = resiter.next();
			if(tmp.getHotelName().indexOf(city) != -1) {
				System.out.printf("%s\n", tmp.getHotelName());
			}
		}
	}
	
	public static void remove_city() {
		Scanner scanner = new Scanner(System.in);
		Reservation tmp;
		ListIterator <Reservation> resiter = reservationslist.listIterator();
		String city;
		System.out.printf("Type a city name for a reservation to delete: ");
		city = scanner.nextLine();
		while(resiter.hasNext()) {
			tmp = resiter.next();
			if(tmp.getHotelName().indexOf(city) != -1) {
				resiter.remove();
			}
		}
	}
}