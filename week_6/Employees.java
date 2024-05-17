package hotel_reservation_system;
import java.util.Scanner;

public class Employees implements Calculable{

	private String name;
	private String surname;
	private double monthly_payment;
	private int id;
	
	////////////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	////////////////////////////////////////////////////////////////////
	
	public Employees() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Name :");
		this.name = scanner.nextLine();
		
		System.out.printf("Surname :");
		this.surname = scanner.nextLine();
	
		System.out.printf("ID :");
		this.id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.printf("Monthly Payment :");
		this.monthly_payment = scanner.nextInt();
		scanner.nextLine();
	}
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public double getCost() {
		return getMonthly_payment();
	}

}
