
public class Weapon extends AbstractItem{

	public Weapon(String name, int value, int weigth) {
		try {
			this.name = name;
			this.value = value;
			this.weigth = weigth;
		} catch (IllegalArgumentException e1) {
			System.out.println("Exception thrown  :" + e1);
		}
	}
}
