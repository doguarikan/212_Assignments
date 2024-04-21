package hotel_reservation_system;

public class Spa extends Services{
	
	int days;
	double spaCost;
	
	public Spa(int customerID, int days, double spaCost) {
		this.CustomerID = customerID;
		this.days = days;
		this.spaCost = spaCost;
	}
	
	@Override
	public String getServiceType() {
		return "Spa";
	}

	@Override
	public double calculateService() {
		return days * spaCost;
	}
	

}
