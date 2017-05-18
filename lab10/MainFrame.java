package lab10;



import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame() {
        super("Swing Designer");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create and add to the frame the controlPanel and designPanel objects
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);

        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel, BorderLayout.CENTER);
        pack();
    }
    //create the main method

    public static void main(String args[]) {
        new MainFrame().setVisible(true);
    }
}
