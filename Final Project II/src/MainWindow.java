/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	//Fields used in the JFrame 
	private InfoPanel userInfo;
	private ModelsPanel modelsPanel;
	private OptionsPanel optionsPanel;
	private FeesPanel feesPanel;
	private JPanel buttonsPanel, companyName;
	private JLabel modelsHeader, title;
	private JButton calcBtn, exitBtn;
	
	
	/*
	 * Constructor to build the JFrame which accepts three values
	 * 
	 *  @param n The name of the applicant
	 *  @param a The address of the applicant 
	 *  @param p The Phone number of the applicant  
	 */
	public MainWindow(String n, String a, String p) {
		super("South FL Motors");
		setLayout(new FlowLayout());
		
		//Panels used in this JFrame
		userInfo = new InfoPanel(n,a,p);
		optionsPanel = new OptionsPanel();
		modelsPanel = new ModelsPanel(optionsPanel);
		feesPanel = new FeesPanel();
		
		//JLabel containing the name of the company
		companyName = new JPanel();
		title = new JLabel("SOUTH FL MOTORS");
		companyName.add(title);
		Dimension dim = getPreferredSize();
		dim.width = 600;
		dim.height = 20;
		companyName.setPreferredSize(dim);
		
		//Title for vehicle models selection group 
		modelsHeader = new JLabel("Available Models", JLabel.CENTER);
		Dimension dim2 = getPreferredSize();
		dim2.width = 600;
		dim2.height = 50;
		modelsHeader.setPreferredSize(dim2);
		
		//JPanel to hold the buttons 
		buttonsPanel = new JPanel();
		
		
		//Logic for the calculate price button
		calcBtn = new JButton("Calculate Total");
		calcBtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//Fields created to hold values needed
				double carPrice = modelsPanel.getModelPrice();
				double methodFees = 0;
				double tradeValue = 0.0;
				int invalidChars = 0;
				double salesTax = carPrice * .06;
				String myTrade = optionsPanel.getTradeValue();
				String paymentMethod = "";
				
				//Generates specific values based on payment method selected 
				if(optionsPanel.getPaymentMethod() == 0) {
					paymentMethod = "Financing";
					methodFees = carPrice * .07;
				}
				else {
					paymentMethod = "Cash";
					methodFees = -750;
				}
				
				//Input validation that checks for non-numeric values in trade-in value
				for(int i =0; i<myTrade.length();i++) {
					if(!Character.isDigit(myTrade.charAt(i))) {
						invalidChars++;
					}
				}
				
				//sets trade in value to 0 if text field is empty 
				if(myTrade.isEmpty())
					myTrade = "0";
				
				//converts the String to a double if only numeric values are found 
				if(invalidChars == 0) {
					tradeValue = Double.parseDouble(myTrade);
				}
				
				//Calculates the final price based on previous fields 
				double finalPrice = carPrice + optionsPanel.getOptionsPrice() + methodFees + salesTax + 350.0 - tradeValue;
				
				//Creates a string made up of values from fields to show user 
				String displayInfo = "";
				displayInfo += "Vehicle Price: $" + carPrice;
				displayInfo += "\nPackages price: $" + optionsPanel.getOptionsPrice();
				displayInfo += "\nPayment Method: " + paymentMethod;
				displayInfo += "\nTrade-in Value: -$" + tradeValue;
				displayInfo += "\nSales Tax: $" + salesTax;
				displayInfo += "\nTotal Price: $" + finalPrice;
				
				//if no vehicle has been selected, warn the user
				if (carPrice == 0) {
					JOptionPane.showMessageDialog(null, "Please select from one of the avaiable models");
				}
				//if there are invalid characters in the text field, warn the user
				else if(invalidChars > 0) {
					JOptionPane.showMessageDialog(null, "Only numeric values allowed in trade field");
				}
				//if the trade value entered is greater than the price of the vehicle, warn the user
				else if(tradeValue > carPrice)
					JOptionPane.showMessageDialog(null, "Trade in value too large. Check again.");
				else 
					JOptionPane.showMessageDialog( null, displayInfo); //display the final message based on no errors 
					
			}
		});
		
		//Logic for the exit button
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//add buttons to this JPanel 
		buttonsPanel.add(calcBtn);
		buttonsPanel.add(exitBtn);
		
		//Add components to the JFrame
		add(companyName);
		add(userInfo);
		add(modelsHeader);
		add(modelsPanel);
		add(optionsPanel);
		add(feesPanel);
		add(buttonsPanel);
		
		//Set the values for the JFrame 
		setSize(750,450);
		this.setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
