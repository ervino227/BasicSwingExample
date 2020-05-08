/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */

import javax.swing.JOptionPane;

public class Application {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myName = JOptionPane.showInputDialog("Enter Your Name");
		String myAddress = JOptionPane.showInputDialog("Enter Your Address");
		String myPhoneNum = JOptionPane.showInputDialog("Enter Your Phone Number");
		
		new MainWindow(myName, myAddress, myPhoneNum);
		
	}

}

