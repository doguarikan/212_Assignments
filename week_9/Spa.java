package hotel_reservation_system;

public class Spa extends Services{
	
	int days;
	double spaCost = 100;
	
	////////////////////////////////////////////////////////////////////
	
	public Spa(int customerID, int days) {
		this.CustomerID = customerID;
		this.days = days;
	}
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public String getServiceType() {
		return "Spa";
	}

	@Override
	public double calculateService() {
		return days * spaCost;
	}

	@Override
	public double getCost() {
		return calculateService();
	}
	

}
