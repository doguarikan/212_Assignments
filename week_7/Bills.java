package hotel_reservation_system;
import java.util.Scanner;

public class Bills implements Calculable {

	private String type;
	private String month;
	private int amount;
	
	////////////////////////////////////////////////////////////////////
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	////////////////////////////////////////////////////////////////////
	
	public Bills() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Type :");
		this.type = scanner.nextLine();
		
		System.out.printf("month :");
		this.month = scanner.nextLine();
	
		System.out.printf("Amount :");
		this.amount = scanner.nextInt();
		scanner.nextLine();
	}
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public double getCost() {
		return getAmount();
	}

}
