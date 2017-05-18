package lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel {

    public Toolbar(Canvas canvas) {
        this.setBounds(0,0,800,200);

        JLabel l1,l2,l3,l4;
        JTextField sidesField, shapesField, strokeField;

        /*Create text labels*/
        l1 = new JLabel("Sides");
        l2 = new JLabel("Shapes");
        l3 = new JLabel("Stroke");

        /*Create text fields*/
        sidesField = new JTextField(5);
        shapesField = new JTextField(5);
        strokeField = new JTextField(5);

        sidesField.setPreferredSize(new Dimension(60,20));
        shapesField.setPreferredSize(new Dimension(60,20));
        strokeField.setPreferredSize(new Dimension(60,20));

        Button drawButton = new Button("Draw");
        drawButton.setPreferredSize(new Dimension(50, 20));
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.drawShapeAt(Integer.parseInt(shapesField.getText()), Integer.parseInt(sidesField.getText()), Integer.parseInt(strokeField.getText()));
            }
        });

        this.add(l1);
        this.add(sidesField);
        this.add(l2);
        this.add(shapesField);
        this.add(l3);
        this.add(strokeField);
        this.add(drawButton);
    }

}
