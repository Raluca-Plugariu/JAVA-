import java.util.*;
public class CustomComparator implements Comparator<Item>{
	public int compare(Item i1, Item i2) {
        return Double.compare(i1.getProfit(),i2.getProfit());
    }
}
