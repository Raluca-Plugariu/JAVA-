package lab5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	 JButton load ;
	 JButton save ;
	
	 public ControlPanel(){
		 load = new JButton("Load");
		 save = new JButton("Save");
		 
		 this.add(load);
		 this.add(save);
		 
	 }
	 
	 
}

