package hotel_reservation_system;

public class Room {
	
	private int daily_cost;
	private int room_size;
	private boolean has_bath;
	
	////////////////////////////////////////////////////////////////////
	
	public int getDaily_cost() {
		return daily_cost;
	}

	public void setDaily_cost(int daily_cost) {
		this.daily_cost = daily_cost;
	}

	public int getRoom_size() {
		return room_size;
	}

	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}

	public boolean isHas_bath() {
		return has_bath;
	}

	public void setHas_bath(boolean has_bath) {
		this.has_bath = has_bath;
	}
	
	////////////////////////////////////////////////////////////////////

	public Room(int daily_cost, int room_size, boolean has_bath) {
		this.daily_cost = daily_cost;
		this.room_size = room_size;
		this.has_bath = has_bath;
	}
	
}

	////////////////////////////////////////////////////////////////////

class Single extends Room {

	public Single() {
		super(100,15,false);
	}
}

class Double extends Room{
	public Double() {
		super(180, 30, false);
	}
}

class Club extends Room{
	public Club() {
		super(250, 45, true);
	}
}

class Family extends Room {
	public Family() {
		super(400, 50, false);
	}
}

class FamilyWithView extends Room {
	public FamilyWithView() {
		super(450, 50, true);
	}
}

class Suite extends Room {
	public Suite() {
		super(650, 80, true);
	}
}
