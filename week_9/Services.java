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
	
	public String displayServiceInfo() {
		return "Customer ID:" + this.CustomerID + ", Service Type: " +this.getServiceType() + ", Cost: " + this.getCost() + "\n";
	}
}
