package hotel_reservation_system;

public class Laundry extends Services{

	int clothingPieces;
	double laundryCost;
	
	////////////////////////////////////////////////////////////////////
	
	public Laundry(int customerID, int clothingPieces, double laundryCost) {
		this.CustomerID = customerID;
		this.clothingPieces = clothingPieces;
		this.laundryCost = laundryCost;
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
