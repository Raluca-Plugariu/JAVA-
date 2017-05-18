/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFunctionality implements ActionListener{
	
	JTextField t;
	public AddFunctionality(JTextField text) {
		t=text;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
            t.getText();
            
		// TODO Auto-generated method st
	}

}