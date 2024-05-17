package hotel_reservation_system;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel_reservation_system {
	static void prints() {
		System.out.printf("1. Create new Reservation with Room Type\n");
		System.out.printf("2. Display all Reservations\n");
		System.out.printf("3. List the reservations for a specific city\n");
		System.out.printf("4. Add extra services to a reservation\n");
		System.out.printf("5. Calculate total cost for each service\n");
		System.out.printf("6. Display the total cost of every customer\n");
		System.out.printf("7. Add an employee\n");
		System.out.printf("8. Add a bill\n");
		System.out.printf("9. Get monthly balance\n");
		System.out.printf("10. List all Services sorted based on cost\n");
		System.out.printf("11. List all Reservations sorted based on hotel names\n");
		System.out.printf("12. Exit\n");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		do {
			prints();
			
	////////////////////////////////////////////////////////////////////
			while(true) {
				try {
					selection = scanner.nextInt();
					scanner.nextLine();
					if (selection >= 1 && selection <= 12) {
	                    break;
	                } else {
	                    System.out.println("You entered an invalid menu option. Enter again.\n\n");
	                    prints();
	                }
				}catch(InputMismatchException e) {
					System.out.printf("You entered an invalid menu option. Enter again.\n\n");
					scanner.nextLine();
					prints();
				}
				
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
			
			else if(selection == MenuOptions.Add_employee.choice)
				MenuOptions.menu(MenuOptions.Add_employee);
			
			else if(selection == MenuOptions.Add_bill.choice)
				MenuOptions.menu(MenuOptions.Add_bill);
			
			else if(selection == MenuOptions.Monthly_balance.choice)
				MenuOptions.menu(MenuOptions.Monthly_balance);
			
			else if(selection == MenuOptions.Sorted_cost.choice)
				MenuOptions.menu(MenuOptions.Sorted_cost);
			
			else if(selection == MenuOptions.Sorted_names.choice)
				MenuOptions.menu(MenuOptions.Sorted_names);
			
			if(selection == 12)
				System.out.println("\nExiting, Goodbye!\n");
			
		}
		while(selection != 12);
		scanner.close();
	}
}

