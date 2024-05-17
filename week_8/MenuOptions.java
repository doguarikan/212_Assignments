package hotel_reservation_system;

public enum MenuOptions{
	Room_type(1),
	Display(2),
	List_city(3),
	Extra_service(4),
	Each_cost(5),
	Total_cost(6),
	Add_employee(7),
	Add_bill(8),
	Monthly_balance(9),
	Sorted_cost(10),
	Sorted_names(11),
	Exit(12);
	int choice;
	
	MenuOptions(int choice){
		this.choice = choice;
	}
	
	////////////////////////////////////////////////////////////////////
	
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
		if(choice == Add_employee)
			Reservation.createEmployee();
		if(choice == Add_bill) 
			Reservation.createBill();
		if(choice == Monthly_balance) 
			Balance.monthlyBalance();
		if(choice == Sorted_cost) 
			Sort.sortServices();
		if(choice == Sorted_names) 
			Sort.sortReservations();
	}

}
