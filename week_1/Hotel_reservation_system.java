package hotel_reservation_system;
import java.util.Scanner;

public class Hotel_reservation_system {
	static int total_room = 0;
	static int max_rooms = 5;
	static int id_counter = 1;
	static int room_counter = 0;
	static int room_cost = 50;
	static int [][] room_informations = new int[max_rooms][3];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		do {
			System.out.printf("1. Create new Standard Room\n");
			System.out.printf("2. Display all room information\n");
			System.out.printf("3. Display the total number rooms\n");
			System.out.printf("0. Exit\n");
			selection = scanner.nextInt();
			
			switch(selection) {
				case 1:
					create_standard_room(scanner);
					break;
				case 2:
					display_info();
					break;
				case 3:
					display_room_number();
					break;
				case 0:
					break;
				default:
			}
		}
		while(selection != 0);
	}
	
	static void create_standard_room(Scanner scanner) {
		int person;
		int price;
		int i = 0;
		
		room_informations[room_counter][i++] = id_counter; 
		System.out.printf("Person count: ");
		person = scanner.nextInt();
		room_informations[room_counter][i++] = person;
		System.out.printf("\n");
		price = calculate_price(person);
		System.out.printf("Price: %d\n",price);
		room_informations[room_counter][i++] = price;
		System.out.printf("Room #%d created!\n",id_counter);
		room_counter++;
		id_counter++;
		total_room++;
	}
	
	static int calculate_price(int person) {
		return (person * room_cost);
	}
	
	static void display_info() {
		int i = 0;
		while(i < room_counter) {
			System.out.printf("Room #%d",room_informations[i][0]);
			System.out.printf(" has %d people with a price total of",room_informations[i][1]);
			System.out.printf(" $%d\n",room_informations[i][2]);
			i++;
		}
	}
	
	static void display_room_number() {
		System.out.printf("%d rooms have been created so far\n", total_room);
	}
}

