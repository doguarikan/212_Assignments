package hotel_reservation_system;

public abstract class Services {
	public int CustomerID;
	public abstract String getServiceType();
	public abstract double calculateService();	
	
	////////////////////////////////////////////////////////////////////
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
}
