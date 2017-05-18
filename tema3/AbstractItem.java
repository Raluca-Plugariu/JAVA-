
public abstract class AbstractItem implements Item {

	String name;
	int value;
	int weigth;


	public double getProfit() {
		return (double) (value / weigth);
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

}
