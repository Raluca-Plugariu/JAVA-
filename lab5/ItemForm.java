package lab5;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


//import javafx.scene.*;


public class ItemForm extends JPanel{

	 JLabel nameLabel ;
	 JLabel pathLabel ;
	 JLabel yearLabel ;
	 


	 JTextField nameTextField ;
	 JTextField pathTextField ;
	 JSpinner yearField;
	 
	 JButton add ;
	 
	 Border blueBorder ;
	 TitledBorder titled;
	 
	 
	public ItemForm(){
				
		nameLabel = new JLabel("Name");
		pathLabel = new JLabel("Path");
		yearLabel = new JLabel("Year");
		
		 nameTextField = new JTextField();
		 pathTextField = new JTextField();
		 yearField = new JSpinner(new SpinnerNumberModel(1950, 1900, 2017, 1));
				
		 add = new JButton("Add");
		
		blueBorder=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		titled = BorderFactory.createTitledBorder(blueBorder,"Add media item");
	}
	
	
	 public JTextField getNameTextField() {
		return nameTextField;
	}


	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}


	public JTextField getPathTextField() {
		return pathTextField;
	}


	public void setPathTextField(JTextField pathTextField) {
		this.pathTextField = pathTextField;
	}


	public JSpinner getYearField() {
		return yearField;
	}


	public void setYearField(JSpinner yearField) {
		this.yearField = yearField;
	}

		
	public void drawItemForm(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets=new Insets(0, 10, 0, 10);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor=GridBagConstraints.NORTHWEST;
		this.add(nameLabel,gbc);
	
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.ipadx=200;
		this.add(this.nameTextField,gbc);
		
		gbc.insets=new Insets(10, 10, 0, 10);
		gbc.gridx=0;
		gbc.gridy=2;
		this.add(pathLabel,gbc);
		
		
		gbc.insets=new Insets(0, 10, 0, 10);
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.ipadx=400;
		this.add(pathTextField,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.insets=new Insets(10, 10, 0, 10);
		this.add(yearLabel,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.ipadx=0;
		gbc.insets=new Insets(0, 10, 0, 10);
		this.add(yearField,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.insets=new Insets(10, 10, 0, 10);
		this.add(add,gbc);
		
		
		this.setBorder(titled);
		
		JFrame frame  = (JFrame) SwingUtilities.getWindowAncestor(this);
		
	}
	
	
	}
