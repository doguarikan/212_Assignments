package hotel_reservation_system;

public enum MenuOptions{
	Create(1),
	Room_type(2),
	Display(3),
	Number(4),
	List_city(5),
	Remove_city(6),
	Exit(7);
	int choice;
	
	MenuOptions(int choice){
		this.choice = choice;
	}
	
	static void menu(MenuOptions choice) {
		if(choice == Create)
			Reservation.createReservation();
		if(choice == Room_type)
			Reservation.createReservation("Room");
		if(choice == Display)
			Reservation.display_info();
		if(choice == Number)
			Reservation.total_num_room();
		if(choice == List_city)
			Reservation.list_city();
		if(choice == Remove_city)
			Reservation.remove_city();
	}

}
