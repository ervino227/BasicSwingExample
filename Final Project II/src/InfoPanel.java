/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */


import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This is a simple JPanel used to show the
 * user information entered at the beginning of the 
 * program. It also creates a random account number. 
 */
public class InfoPanel extends JPanel {
	private String accountNumber;
	private JLabel name;
	private JLabel address;
	private JLabel phoneNum;
	private JLabel account;
	
	/*
	 * This constructor takes three parameters to create the user information
	 * 
	 * @param n The name of the applicant 
	 * @param a The address of the applicant
	 * @param p The phone number of the applicant 
	 */
	public InfoPanel(String n, String a, String p) {
		super();
		setLayout(new GridLayout(0,1));

		Dimension dim = getPreferredSize();
		dim.width = 600;
		dim.height = 75;
		this.setPreferredSize(dim);
		
		this.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
		
		//Sets default values for the parameters if none were entered 
		if(n.isEmpty()) {
			n = "-no name-";
		}
		if(a.isEmpty()) {
			a = "-no address-";
		}
		if(p.isEmpty()) {
			p = "-no phone-";
		}
		
		//adds values to the instance variables 
		name = new JLabel("Applicant Name: " + n);
		address = new JLabel("Address: " + a);
		phoneNum = new JLabel("Phone Number: " + p);
		
		//Creates a random number of 5 digits for the account number 
		Random r = new Random();
		accountNumber = "";
		for(int i=0; i<5;i++) {
			int thisNum = r.nextInt(10);
			accountNumber += thisNum;
		}
		account = new JLabel("Account Number: #" + accountNumber);
		
		//Adds components to this JPanel 
		add(name);
		add(address);
		add(phoneNum);
		add(account);
	}
}
