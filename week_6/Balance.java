package hotel_reservation_system;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;


public class Balance {
	private static String month;
	private static Calculable temp;
	private static float bill;
	private static float employee;
	private static float income;
	static Iterator<Calculable> iterator = Calculable.calculablelist.iterator();
	
	
	public static void monthlyBalance() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter the month: \n");
		month = scanner.nextLine();
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp instanceof Services) {
				if(temp instanceof Reservation && ((Reservation) temp).getReservationMonth().equals(month)) {
					System.out.printf("For reservation ID: %d,  Service type: Room booking, Service Cost: %.2f\n",((Reservation) temp).getCustomerID(), ((Reservation) temp).getCost());
					income += ((Reservation) temp).getCost();
				}
				else if(temp instanceof Spa) {
					System.out.printf("For reservation ID: %d, Service type: Spa, Service Cost: %.2f\n",((Spa) temp).getCustomerID(), ((Spa) temp).getCost());
					income += ((Spa) temp).getCost();
				}
				else if(temp instanceof Laundry) {
					System.out.printf("For reservation ID: %d, Service type: Laundry, Service Cost: %.2f\n",((Laundry) temp).getCustomerID(), ((Laundry) temp).getCost());
					income += ((Laundry) temp).getCost();
				}
			}
			else if(temp instanceof Bills && ((Bills) temp).getMonth().equals(month)) {
				bill += ((Bills) temp).getAmount();
			}
			else if(temp instanceof Employees) {
				employee += ((Employees) temp).getMonthly_payment();
			}	
		}
		System.out.printf("Total monthly income: %.2f\n", income);
		System.out.printf("Total monthly bills due: %.2f\n", bill);
		System.out.printf("Total monthly employee cost: %.2f\n", employee);
		System.out.printf("End of month balance: %.2f\n\n", (income - bill - employee));
	}
}
