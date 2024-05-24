package hotel_reservation_system;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelGui extends JFrame{
	
	public static JTextArea text_area;
	public static JPanel text_panel;
	public static JButton btn_displayReservation;
	public static JButton btn_displayExtraServices;
	public static JButton btn_displayResForCity;
	public static JMenuBar bar_menu;
	public static JMenu menu_file;
	public static JMenu menu_new;
	public static JMenu menu_help;
	public static JMenuItem mItem_reservation;
	public static JMenuItem mItem_services;
	public static JMenuItem mItem_contents;
	public static JMenuItem mItem_about;
	public static JMenuItem mItem_exitProgram;
	
	public HotelGui() {
		
		text_area = new JTextArea();
		text_area.setColumns(45);
		text_area.setRows(24);
		text_area.setEditable(false);
		
		text_panel = new JPanel();
		text_panel.setBackground(Color.WHITE);
		text_panel.add(text_area);
		
		btn_displayExtraServices = new JButton();
		btn_displayExtraServices.setText("Display Extra Services");

		btn_displayReservation = new JButton();
		btn_displayReservation.setText("Display Reservations");

		btn_displayResForCity = new JButton();
		btn_displayResForCity.setText("Display Reservations For City");

		bar_menu = new JMenuBar();

		menu_file = new JMenu("File");
		menu_help = new JMenu("Help");
		menu_new = new JMenu("New");
		
		bar_menu.add(menu_file);
		bar_menu.add(menu_new);
		bar_menu.add(menu_help);

		mItem_reservation = new JMenuItem("Reservation");
		mItem_services = new JMenuItem("Services");

		menu_new.add(mItem_reservation);
		menu_new.add(mItem_services);

		mItem_about = new JMenuItem("About");
		mItem_contents = new JMenuItem("Contents");
		
		menu_help.add(mItem_about);
		menu_help.add(mItem_contents);

		mItem_about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(text_panel,"About developer:\n Doğu Baha Arıkan \n ID: 20210702090");
			}
		});

		mItem_contents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(text_panel,"Manual Instructions:\n Press new to create reservation or to use extra services \n "
						+ "Press display buttons to display extra services or reservations");
				
			}
		});

		mItem_exitProgram = new JMenuItem("Exit");
		menu_file.add(mItem_exitProgram);

		mItem_exitProgram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
	
		this.setTitle("Hotel Reservation System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(600,600);
		this.setJMenuBar(bar_menu);
		this.setVisible(true);
		this.add(btn_displayExtraServices);
		this.add(btn_displayResForCity);
		this.add(btn_displayReservation);
		this.add(text_panel);
	}
}