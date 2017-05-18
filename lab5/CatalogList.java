package lab5;
import javax.swing.*;


public class CatalogList extends JList {
    DefaultListModel<String> model = new DefaultListModel<>();
    public CatalogList() {
        this.setBorder(BorderFactory.createTitledBorder("Catalog Items"));
        this.setModel(model);        
    }    
    public void addItem(String item) {
        model.addElement(item);
    }
}