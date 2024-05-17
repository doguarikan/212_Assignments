package hotel_reservation_system;

public class RoomTypeException extends Exception{
	String message;
	public RoomTypeException(String message) {
		this.message = message;
	}
	
	////////////////////////////////////////////////////////////////////
	@Override
	public String getMessage() {
		return this.message;
	}
}
