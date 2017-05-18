

public class MainClass {

	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack(10);
		 Book b1 = new Book("Dragon Rising", 3, 5);
		 Book b2 = new Book("A Blade in the Dark", 3, 5);
		 Weapon w1 = new Weapon("Ancient Sword", 5, 10);
		
		 Food food1 = new Food("Cabbage",2,4);
		 Food food2 = new Food("Rabbit",2,4);
		 knapsack.add(b1,b2);
		 knapsack.add(w1);
		 knapsack.add(food1,food2);
		 
		System.out.println(knapsack);
	}

}
