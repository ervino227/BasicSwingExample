/*
 * Author: Ervens Delva
 * Course: Programming II
 * Semester: Spring 2020
 */


import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This is a simple JPanel class used to display 
 * the fees and taxes associated with the purchase
 */
public class FeesPanel extends JPanel {
	JLabel header;
	JLabel tagLabel;
	JLabel taxLabel;
	
	public FeesPanel() {
		setLayout(new GridLayout(0,1));
		
		Dimension dim = getPreferredSize();
		dim.width = 400;
		dim.height = 50;
		this.setPreferredSize(dim);
		
		//Create the JLabel objects 
		header = new JLabel("FEES");
		tagLabel = new JLabel("Title + Tag: $325");
		taxLabel = new JLabel("Sales Tax: 6%");
		
		//Add the JLabel objects to this panel 
		add(header);
		add(tagLabel);
		add(taxLabel);
	}
}
