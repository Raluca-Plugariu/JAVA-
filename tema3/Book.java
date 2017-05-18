
public class Book extends AbstractItem{

	public Book(String name, int value, int weigth) {
		try {
			this.name = name;
			this.value = value;
			this.weigth = weigth;
		} catch (IllegalArgumentException e1) {
			System.out.println("Exception thrown  :" + e1);
		}
	}
}
