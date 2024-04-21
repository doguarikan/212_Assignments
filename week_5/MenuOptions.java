package hotel_reservation_system;

public enum MenuOptions{
	Room_type(1),
	Display(2),
	List_city(3),
	Extra_service(4),
	Each_cost(5),
	Total_cost(6),
	Exit(7);
	int choice;
	
	MenuOptions(int choice){
		this.choice = choice;
	}
	
	static void menu(MenuOptions choice) {
		if(choice == Room_type)
			Reservation.createReservation("Room");
		if(choice == Display)
			Reservation.display_info();
		if(choice == List_city)
			Reservation.list_city();
		if(choice == Extra_service)
			Reservation.extra_service();
		if(choice == Each_cost)
			Reservation.each_cost();
		if(choice == Total_cost)
			Reservation.total_cost();
	}

}
