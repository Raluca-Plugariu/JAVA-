package lab5;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class MediaFrame  extends JFrame{
	private static final long serialVersionUID = 1L;
	public MediaFrame(){
		super("Catalog 1.0");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ItemForm itemF= new ItemForm();
		itemF.setLayout(new GridBagLayout());
		itemF.drawItemForm();
		CatalogList catalogL  = new CatalogList();
		ControlPanel controlP = new ControlPanel();
		
		
		itemF.add.addActionListener(new ActionListener()
		{
		  
		@Override
		public void actionPerformed(ActionEvent press) {
			StringBuilder sb = new StringBuilder();
			sb.append(itemF.getNameTextField().getText());
			sb.append(" - ");
			sb.append(itemF.getPathTextField().getText());
			sb.append(" - ");
			sb.append(itemF.getYearField().getValue());
			catalogL.addItem(sb.toString());
		}
		});
	//	buttonsPannel.add(b1);
	//	buttonsPannel.add(b2);
		
		this.add(itemF,BorderLayout.NORTH);
		this.add(catalogL,BorderLayout.CENTER);
		this.add(controlP,BorderLayout.SOUTH);
	}
}