package hotel_reservation_system;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

public class Reservation extends Services{
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	static int totalNumOfReservations = 0;
	private Room room;
	private RoomType roomType;
	static ArrayList<Reservation> reservationslist = new ArrayList<>();
	static ArrayList<Services> serviceslist = new ArrayList<>();
	
	static Scanner scanners = new Scanner(System.in);
	
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
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	////////////////////////////////////////////////////////////////////
	
	public Reservation(String type) {
		System.out.printf("ROOM INFOS: \n\nRoom Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false\n"
				+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false\n"
				+ "Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true\n"
				+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false\n"
				+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true\n"
				+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true\n");
		
		Reservation.totalNumOfReservations++;
		
		System.out.printf("Hotel Name: ");
		hotelName = scanners.nextLine();
		
		System.out.printf("\nReservation Month: ");
		reservationMonth = scanners.nextLine();
		
		System.out.printf("\nReservation Start: ");
		reservationStart = scanners.nextInt();
		scanners.nextLine();
		
		System.out.printf("\nReservation End: ");
		reservationEnd = scanners.nextInt();
		scanners.nextLine();
		
		System.out.printf("\nRoom Type: ");
		roomType = RoomType.valueOf(scanners.nextLine());
		
		if(roomType == RoomType.Single) {
			room = new Single();
		}
		else if(roomType == RoomType.Double) {
			room = new Double();
		}
		else if(roomType == RoomType.Club) {
			room = new Club();
		}
		else if(roomType == RoomType.Family) {
			room = new Family();
		}
		else if(roomType == RoomType.Familywithview) {
			room = new FamilyWithView();
		}
		else if(roomType == RoomType.Suite) {
			room = new Suite();
		}
		
		System.out.printf("\nReservation ID : %d is created!\n", Reservation.totalNumOfReservations);
	}
	
	////////////////////////////////////////////////////////////////////

	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost) {
		return(daily_cost*(reservation_end-reservation_start));
	}
	
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost, int multiplier) {
		return(multiplier * daily_cost*(reservation_end-reservation_start));
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void createReservation(String type){
		if(Reservation.totalNumOfReservations < reservationslist.size()+1) {
			Reservation reservation = new Reservation(type);
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
						reservations.getRoom().getDaily_cost(),2);
			}
			else
				price = calculate_total_price(reservations.getReservationStart(),reservations.getReservationEnd(),
						reservations.getRoom().getDaily_cost());
			
			System.out.printf("Reservation for a %s room in %s starts on %s %d and ends on %s\n", reservations.getRoomType()
	        		,reservations.getHotelName(), reservations.getReservationMonth(),
	        		reservations.getReservationStart(),reservations.getReservationEnd());
	        System.out.printf("Reservation has total cost of $%d\n\n",price);
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void list_city() {
		Reservation tmp;
		ListIterator <Reservation> resiter = reservationslist.listIterator();
		String city;
		System.out.printf("Type a city name for a reservation search: ");
		city = scanners.nextLine();
		while(resiter.hasNext()) {
			tmp = resiter.next();
			if(tmp.getHotelName().indexOf(city) != -1) {
				System.out.printf("%s\n", tmp.getHotelName());
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void extra_service() {
		int extra_selection;
		int id;
		int days;
		int clothes;
		System.out.printf("Please select one of the extra services from below: \n");
		System.out.printf("1. Laundry Service \n 2. Spa Service \n");
		extra_selection = scanners.nextInt();
		scanners.nextLine();
		
		if(extra_selection == 1) {
			System.out.printf("Type the reservation ID to credit this service: ");
			id = scanners.nextInt();
			
			System.out.printf("How many pieces of clothing?");
			clothes = scanners.nextInt();

			serviceslist.add(new Laundry(id,clothes,20));
		}
		
		else if(extra_selection == 2) {
			System.out.printf("Type the reservation ID to credit this service: ");
			id = scanners.nextInt();
			
			System.out.printf("How many days?");
			days = scanners.nextInt();
			
			serviceslist.add(new Spa(id,days,100));
		}
		
	}
	
	
	////////////////////////////////////////////////////////////////////
	
	public static void each_cost() {
		
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void total_cost() {
		ListIterator <Reservation> resiter = reservationslist.listIterator();
		Reservation tmp;
		while(resiter.hasNext()) {
			tmp = resiter.next();
			System.out.printf("The total cost of all services of the reservation with ID: %d is $%.2f\n",tmp.getCustomerID(), tmp.calculateService());
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public String getServiceType() {
		return "Room Booking";
	}

	@Override
	public double calculateService() {
		int days = getReservationEnd()-getReservationStart();
		int multlpy = 1;
		if(getReservationMonth().equals("June") || getReservationMonth().equals("July") || getReservationMonth().equals("August"))
			multlpy = 2;
		return (days * multlpy * getRoom().getDaily_cost());
	}
}