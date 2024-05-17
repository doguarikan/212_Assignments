package hotel_reservation_system;
import java.util.Scanner;

import hotel_reservation_system.Reservation.RoomType;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.InputMismatchException;

public class Reservation extends Services implements Calculable{
	private String hotelName;
	private String reservationMonth;
	private String roomtyp;
	private int reservationStart;
	private int reservationEnd;
	static int totalNumOfReservations = 0;
	static int temp;
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
		
		while(true) {
			System.out.printf("\nReservation Start: ");
			try {
				reservationStart = scanners.nextInt();
				scanners.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.printf("Reservation Start must be a numeric value!");
				scanners.nextLine();
			}
		}
		
		while(true) {
			System.out.printf("\nReservation End: ");
			try {
				reservationEnd = scanners.nextInt();
				scanners.nextLine();
				break;
			}catch(InputMismatchException e) {
				System.out.printf("Reservation End must be a numeric value!");
				scanners.nextLine();
			}
		}
		
		
		while(true) {
			System.out.printf("\nRoom Type: ");
			try {
				roomtyp = scanners.nextLine();
				roomchecker(roomtyp);
				roomType = RoomType.valueOf(roomtyp);
			
				if(roomType == RoomType.Single) {
					room = new Single();
					break;
				}
				else if(roomType == RoomType.Double) {
					room = new Double();
					break;
				}
				else if(roomType == RoomType.Club) {
					room = new Club();
					break;
				}
				else if(roomType == RoomType.Family) {
					room = new Family();
					break;
				}
				else if(roomType == RoomType.Familywithview) {
					room = new FamilyWithView();
					break;
				}
				else if(roomType == RoomType.Suite) {
					room = new Suite();
					break;
				}
			}catch(RoomTypeException a) {
				System.out.println(a);
			}
		}
		System.out.printf("\nReservation ID : %d is created!\n", Reservation.totalNumOfReservations);
		this.CustomerID = Reservation.totalNumOfReservations;
	}
	public static void roomchecker(String room) throws RoomTypeException {
		if(!RoomType.Single.name().equals(room) && !RoomType.Double.name().equals(room) && !RoomType.Club.name().equals(room) && !RoomType.Family.name().equals(room) && 
				!RoomType.Familywithview.name().equals(room) && !RoomType.Suite.name().equals(room)) {
			throw new RoomTypeException("Room Type is not valid!");
		}
	}
	
	////////////////////////////////////////////////////////////////////

	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost) {
		return(daily_cost*(reservation_end-reservation_start));
	}
	
	public static int calculate_total_price(int reservation_start, int reservation_end, int daily_cost, int multiplier) {
		return(multiplier * daily_cost*(reservation_end-reservation_start));
	}
	
	////////////////////////////////////////////////////////////////////
	
	public static void createReservation(String type) {
		if(Reservation.totalNumOfReservations < reservationslist.size()+1) {
			Reservation reservation = new Reservation(type);
			reservationslist.add(reservation);
			Calculable.calculablelist.add(reservation);
			
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
		System.out.printf("1. Laundry Service \n2. Spa Service \n");
		extra_selection = scanners.nextInt();
		scanners.nextLine();
		
		if(extra_selection == 1) {
			System.out.printf("Type the reservation ID to credit this service: \n");
			id = scanners.nextInt();
			
			System.out.printf("How many pieces of clothing?\n");
			while(true) {
				try {
					temp = scanners.nextInt();
					scanners.nextLine();
					break;
				}catch(InputMismatchException e) {
					System.out.printf("Clothing count must be a numeric value!\n");
					scanners.nextLine();
					System.out.printf("How many pieces of clothing?\n");
				}
			}
			clothes = temp;
			Calculable.calculablelist.add(new Laundry(id,clothes,20));
			serviceslist.add(new Laundry(id,clothes,20));
		}
		
		else if(extra_selection == 2) {
			System.out.printf("Type the reservation ID to credit this service: \n");
			id = scanners.nextInt();
			
			System.out.printf("How many days?\n");
			while(true) {
				try {
					temp = scanners.nextInt();
					scanners.nextLine();
					break;
				}catch(InputMismatchException e) {
					System.out.printf("Day count must be a numeric value!\n");
					scanners.nextLine();
					System.out.printf("How many days?\n");
				}
			}
			days = temp;
			Calculable.calculablelist.add(new Spa(id,days,100));
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
	
	///////////////////////////////////////////////////////////////////
	
	@Override
	public double getCost() {
		return calculateService();
		
	}
	
	///////////////////////////////////////////////////////////////////
	
	public static void createEmployee() {
		Employees employee = new Employees();
		calculablelist.add(employee);
	}

	///////////////////////////////////////////////////////////////////
	
	public static void createBill() {
		Bills bill = new Bills();
		calculablelist.add(bill);
	}
	
	///////////////////////////////////////////////////////////////////
	

}