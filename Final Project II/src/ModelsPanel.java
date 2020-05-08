/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ModelsPanel extends JPanel implements ActionListener {
	//Fields used in this JPanel 
	JRadioButton s40, s60, s70, s80;
	OptionsPanel options;
	
	/*
	 * Constructor takes in an OptionsPanel as a
	 * parameter to be used with the ActionListener Event
	 */
	public ModelsPanel(OptionsPanel options) {
		//import JPanel from another .java file 
		this.options = options;
		
		//Create JRadio Buttons
		s40 = new JRadioButton("s40 ($27,700)");
		s60 = new JRadioButton("s60 ($32,500)");
		s70 = new JRadioButton("s70 ($36,000)");
		s80 = new JRadioButton("s80 ($44,000)");
		
		//Add listeners to JRadionButtons
		s40.addActionListener(this);
		s60.addActionListener(this);
		s70.addActionListener(this);
		s80.addActionListener(this);
		
		//Create a ButtonGroup and and buttons to group
		ButtonGroup g = new ButtonGroup();
		g.add(s40);
		g.add(s60);
		g.add(s70);
		g.add(s80);
		
		//a JPanel made specifically to hold JRadioButtons 
		JPanel radioPanel = new JPanel(new GridLayout(1,0));
        radioPanel.add(s40);
        radioPanel.add(s60);
        radioPanel.add(s70);
        radioPanel.add(s80);
        
        //add the contents to this JPanel 
        add(radioPanel);
	}
	
	//Listener which enables and disables a check-box in the OptionsPanel .java file 
	public void actionPerformed(ActionEvent e) {
		if ("s40 ($27,700)".equals(e.getActionCommand()) || "s60 ($32,500)".equals(e.getActionCommand())) {
	        options.disableOptions();
	    } else {
	        options.enableOptions();
	    }
	}
	
	/*
	 * Method to get the value associated with the JRadioButton
	 * that has been selected 
	 */
	public double getModelPrice() {
		if(s40.isSelected())
			return 27700;
		else if(s60.isSelected())
			return 32500;
		else if(s70.isSelected())
			return 36000;
		else if(s80.isSelected())
			return 44000;
		else return 0;
	}
}
