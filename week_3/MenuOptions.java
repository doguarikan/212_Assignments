package hotel_reservation_system;

public enum MenuOptions{
	Create(1),
	Room_type(2),
	Display(3),
	Number(4),
	Exit(5);
	int choice;
	
	MenuOptions(int choice){
		this.choice = choice;
	}
	static void menu(MenuOptions choice) {
		if(choice == Create)
			Reservation.createReservation();
		else if(choice == Room_type)
			Reservation.createReservation("Room");
		else if(choice == Display);
			Reservation.display_info();
		if(choice == Number)
			Reservation.total_num_room();
	}

}
