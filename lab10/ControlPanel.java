/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Stefana
 */
public class ControlPanel extends JPanel{
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    private final JButton createButtonS = new JButton("Save");
    private final JButton createButtonL = new JButton("Load");
    
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(classNameLabel); 
        add(classNameField); 
        add(textLabel); 
        add(textField); 
        add(createButton);
        add(createButtonS);
        add(createButtonL);
        
        createButton.addActionListener(e -> {
            JComponent comp = createDynamicComponent(classNameField.getText());
            try {
                setComponentText(comp, textField.getText());
            } catch (IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.designPanel.addAtRandomLocation(comp);
        });
    }
    private JComponent createDynamicComponent(String className) {
	   //implement this method
                   try {
            Class newClass = Class.forName(className);
            JComponent comp = (JComponent)newClass.newInstance();
            return comp;
        }  catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    private void setComponentText(JComponent comp, String text) throws IllegalArgumentException, InvocationTargetException {
	   //implement this method
            try {
            Class newClass = comp.getClass();
            Method method = newClass.getMethod("setText", new Class[]{String.class});
            method.invoke(comp, text);
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    }
