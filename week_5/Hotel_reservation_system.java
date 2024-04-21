package hotel_reservation_system;
import java.util.Scanner;

public class Hotel_reservation_system {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.printf("1. Create new Reservation with Room Type\n");
			System.out.printf("2. Display all Reservations\n");
			System.out.printf("3. List the reservations for a specific city\n");
			System.out.printf("4. Add extra services to a reservation\n");
			System.out.printf("5. Calculate total cost for each service\n");
			System.out.printf("6. Display the total cost of every customer\n");
			System.out.printf("7. Exit\n");
			
	////////////////////////////////////////////////////////////////////
			
			if (scanner.hasNextInt()) {
				selection = scanner.nextInt();
				scanner.nextLine();
			}
			
			if(selection == MenuOptions.Room_type.choice)
				MenuOptions.menu(MenuOptions.Room_type);
			
			else if(selection == MenuOptions.Display.choice)
				MenuOptions.menu(MenuOptions.Display);
			
			else if(selection == MenuOptions.List_city.choice)
				MenuOptions.menu(MenuOptions.List_city);
			
			else if(selection == MenuOptions.Extra_service.choice)
				MenuOptions.menu(MenuOptions.Extra_service);
			
			else if(selection == MenuOptions.Each_cost.choice)
				MenuOptions.menu(MenuOptions.Each_cost);
			
			else if(selection == MenuOptions.Total_cost.choice)
				MenuOptions.menu(MenuOptions.Total_cost);
			
		}
		while(selection != 7);
		scanner.close();
	}
}

