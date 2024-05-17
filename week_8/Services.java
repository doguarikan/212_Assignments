package hotel_reservation_system;

public abstract class Services implements Calculable{
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
	
	public void displayServiceInfo() {
		System.out.printf("Customer ID: %d, Service Type: %s, Cost: %.2f\n",this.CustomerID,this.getServiceType(),this.getCost());
	}
}
