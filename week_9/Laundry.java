package hotel_reservation_system;

public class Laundry extends Services{

	int clothingPieces;
	double laundryCost = 20;
	
	////////////////////////////////////////////////////////////////////
	
	public Laundry(int customerID, int clothingPieces) {
		this.CustomerID = customerID;
		this.clothingPieces = clothingPieces;
	}
	
	////////////////////////////////////////////////////////////////////
	
	@Override
	public String getServiceType() {
		return "Laundry";
	}

	@Override
	public double calculateService() {
		return clothingPieces * laundryCost;
	}

	@Override
	public double getCost() {
		return calculateService();
	}

}
