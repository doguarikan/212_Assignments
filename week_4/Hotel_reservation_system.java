package hotel_reservation_system;
import java.util.Scanner;

public class Hotel_reservation_system {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.printf("1. Create new Reservation\n");
			System.out.printf("1. Create new Reservation with Room Type\n");
			System.out.printf("3. Display all Reservations\n");
			System.out.printf("4. Display the total number of Reservations\n");
			System.out.printf("5. List the reservations for a specific city\n");
			System.out.printf("6. Remove reservations in a specific city\n");
			System.out.printf("7. Exit\n");
			
	////////////////////////////////////////////////////////////////////
			
			if (scanner.hasNextInt()) {
				selection = scanner.nextInt();
				scanner.nextLine();
			}
			if(selection == MenuOptions.Create.choice)
				MenuOptions.menu(MenuOptions.Create);
			
			else if(selection == MenuOptions.Room_type.choice)
				MenuOptions.menu(MenuOptions.Room_type);
			
			else if(selection == MenuOptions.Display.choice)
				MenuOptions.menu(MenuOptions.Display);
			
			else if(selection == MenuOptions.Number.choice)
				MenuOptions.menu(MenuOptions.Number);
			
			else if(selection == MenuOptions.List_city.choice)
				MenuOptions.menu(MenuOptions.List_city);
			
			else if(selection == MenuOptions.Remove_city.choice)
				MenuOptions.menu(MenuOptions.Remove_city);
			
		}
		while(selection != 7);
		scanner.close();
	}
}

