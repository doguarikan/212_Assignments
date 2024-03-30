package hotel_reservation_system;

public class Room {
	
	public int daily_cost;
	public int room_size;
	public boolean has_bath;
	
	public Room(int daily_cost, int room_size, boolean has_bath) {
		this.daily_cost = daily_cost;
		this.room_size = room_size;
		this.has_bath = has_bath;
	}
	
}
