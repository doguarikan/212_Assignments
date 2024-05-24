package hotel_reservation_system;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.LayerUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel_reservation_system {
	static String city;
	static String hotel_name;
	static String month;
	static String start;
	static String end;
	static String ID;
	static String num_clothes;
	static String num_days;
	static int IDnum;
	static int numclothes;
	static int numdays;
	static int resStart;
	static int resEnd;
	
	public static void main(String[] args) {
		HotelGui gui = new HotelGui();
		ArrayList<Calculable> calculablelist= new ArrayList<Calculable>();
		
		
		HotelGui.mItem_reservation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				city = JOptionPane.showInputDialog("Enter City: ");
				hotel_name = JOptionPane.showInputDialog("Enter Hotel Name: ");
				month = JOptionPane.showInputDialog("Enter Reservation Month: ");
				start = JOptionPane.showInputDialog("Enter Reservation Start: ");
				end = JOptionPane.showInputDialog("Enter Reservation End: ");
			
				resStart = Integer.parseInt(start);
				resEnd = Integer.parseInt(end);
				Reservation res = new Reservation(hotel_name,city,month,resStart,resEnd);
				calculablelist.add(res);
			}

		});

		HotelGui.mItem_services.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String input = JOptionPane.showInputDialog("Select one of the extra services below:\n1.Laundry service\n2.Spa service");
				if(input.equals("1")){
					ID = JOptionPane.showInputDialog("Type the reservation ID:");
					IDnum = Integer.parseInt(ID);
					
					num_clothes = JOptionPane.showInputDialog("Number of clothes:");
					numclothes = Integer.parseInt(num_clothes);

					Laundry lan = new Laundry(IDnum,numclothes);
					calculablelist.add(lan);
				}
				else if(input.equals("2")){
					ID = JOptionPane.showInputDialog("Type the reservation ID:");
					IDnum = Integer.parseInt(ID);
					
					num_days = JOptionPane.showInputDialog("Number of days:");
					numdays = Integer.parseInt(num_days);

					Spa spa = new Spa(IDnum,numdays);
					calculablelist.add(spa);
				}
			}
		});

		HotelGui.btn_displayReservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				for (Calculable cal:calculablelist){
					if(cal instanceof Reservation){
						HotelGui.text_area.append(((Reservation) cal).display_info() + "\n");
					}
				}
			}	
		});
		
		HotelGui.btn_displayExtraServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				for (Calculable ser:calculablelist){
					if(ser instanceof Reservation){
						if(ser instanceof Laundry)
							HotelGui.text_area.append(((Laundry) ser).displayServiceInfo() + "\n");
						else if(ser instanceof Spa)
						HotelGui.text_area.append(((Spa) ser).displayServiceInfo() + "\n");
					}
				}
			}	
		});

		HotelGui.btn_displayResForCity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String cityname;
				cityname = JOptionPane.showInputDialog("Enter the city:");
				for (Calculable res:calculablelist){
					if(res instanceof Reservation){
						if(cityname.equals(((Reservation)res).getHotelName()))
							HotelGui.text_area.append(((Reservation) res).display_info() + "\n");
					}
				}
			}	
		});
		
	}
}

