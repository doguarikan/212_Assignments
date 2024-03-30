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
			System.out.printf("5. Exit\n");
			selection = scanner.nextInt();
			scanner.nextLine();
			if(selection == MenuOptions.Create.choice)
				MenuOptions.menu(MenuOptions.Create);
			
			else if(selection == MenuOptions.Room_type.choice)
				MenuOptions.menu(MenuOptions.Room_type);
			
			else if(selection == MenuOptions.Display.choice)
				MenuOptions.menu(MenuOptions.Display);
			
			else if(selection == MenuOptions.Number.choice)
				MenuOptions.menu(MenuOptions.Number);
		}
		while(selection != 5);
		scanner.close();
	}
}

