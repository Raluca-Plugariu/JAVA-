import java.util.*;

public class Knapsack {

	int capacity;
	ArrayList<Item> Items = new ArrayList <Item>();
	int itemsWeigth;

	public Knapsack(int capacity) {
		try {
			this.capacity = capacity;
			this.itemsWeigth=0;
		} catch (IllegalArgumentException e1) {
			System.out.println("Exception thrown  :" + e1);
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		try {
			this.capacity = capacity;
		} catch (IllegalArgumentException e1) {
			System.out.println("Exception thrown  :" + e1);
		}
	}

	public void add(Item...items ) {
		
		for (Item i : items) {
			if(this.capacity==this.itemsWeigth)
				break;
			if(this.capacity>=this.itemsWeigth + i.getWeigth())
			{
			this.Items.add(i);
			this.itemsWeigth+=i.getWeigth();
			}
		}
	}
	
		
	public String toString() {
		String itemsName = new String();
		for (Item i : this.Items) {
			itemsName += i.getName();
			itemsName += "\n";
		}
		return itemsName;
	}
}
