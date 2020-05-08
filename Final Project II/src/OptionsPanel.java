/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class OptionsPanel extends JPanel {
	//Fields used in this JPanel 
	private JPanel packages;
	private JPanel tradeIn;
	private JPanel paymentMethod;
	private JCheckBox packageA, packageB, metalPaint;
	private JRadioButton fin, cash;
	private JTextField tradeValue;
	
	public OptionsPanel() {
		setLayout(new GridLayout(1,3));
		
		//////////////// Section 1 ////////////////////////
		packages = new JPanel(new GridLayout(0,1));
		//Creates a border outline in this panel 
		Border innerBorder = BorderFactory.createLineBorder(Color.BLACK);
		Border outerBorder = BorderFactory.createEmptyBorder(10,5,10,5);
		packages.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		//Creates the component for this panel 
		JLabel options = new JLabel("Additional Options", JLabel.CENTER);
		packageA = new JCheckBox("Package A - $2,200 (All Models)", false);
		packageB = new JCheckBox("Package B - $3,250 (s70 or s80)",false);
		metalPaint = new JCheckBox("Metallic Paint-$650",false);
		//adds the components to this panel 
		packages.add(options);
		packages.add(packageA);
		packages.add(packageB);
		packages.add(metalPaint);
		
		//////////////// Section 2 ////////////////////////
		//Panel creation
		tradeIn = new JPanel(new GridLayout(0,1));
		//Components
		JLabel myTrade = new JLabel("Trade-In", JLabel.CENTER);
		JPanel filler = new JPanel();
		JLabel desc = new JLabel("Trade Value:", JLabel.CENTER);
		tradeValue = new JTextField("0",10);
		//add components
		tradeIn.add(myTrade);
		JPanel cashPart = new JPanel(new GridLayout(1,0));
		cashPart.add(desc);
		cashPart.add(tradeValue);
		tradeIn.add(cashPart);
		tradeIn.add(filler);
		
		//////////////// Section 3 ////////////////////////
		paymentMethod = new JPanel(new GridLayout(0,1));
		//Creates a border outline in this panel 
		Border innerBorder2 = BorderFactory.createLineBorder(Color.BLACK);
		Border outerBorder2 = BorderFactory.createEmptyBorder(10,5,10,5);
		paymentMethod.setBorder(BorderFactory.createCompoundBorder(outerBorder2, innerBorder2));
		//creates the components for this panel 
		JLabel myPayment = new JLabel("Payment Method", JLabel.CENTER);
		fin = new JRadioButton("Financing (7% Interest)");
		cash = new JRadioButton("Cash ($750 discount)");
		ButtonGroup bg = new ButtonGroup();
		bg.add(fin);
		bg.add(cash);
		paymentMethod.add(myPayment);
		paymentMethod.add(fin);
		paymentMethod.add(cash);
		//add components to panel 
		add(packages);
		add(paymentMethod);
		add(tradeIn);
	}
	
	//method used to disable the Package B Check box 
	public void disableOptions() {
		packageB.setEnabled(false);
		packageB.setSelected(false);
	}
	//method used to enable the Package B Check box 
	public void enableOptions() {
		packageB.setEnabled(true);
	}
	
	//method used to retrieve the price of the selected vehicle model 
	public double getOptionsPrice() {
		double price = 0;
		if(packageA.isSelected())
			price += 2200.0;
		if(packageB.isSelected())
			price += 3250.0;
		if(metalPaint.isSelected())
			price += 650.0;
		return price;
	}
	
	//method used to determine the method of payment selected by the user
	public int getPaymentMethod() {
		if(fin.isSelected())
			return 0;
		else 
			return 1;
	}
	
	//method used to retrieve the trade-in value for the number entered in
	// the text-field 
	public String getTradeValue() {
		String myValue = tradeValue.getText();
		return myValue;
	}
	
}