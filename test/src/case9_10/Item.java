package case9_10;

public class Item {
	private String name;
	private int price;
	private int weight;

	public Item(String name, int price, int weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public void setName(String name) { this.name = name; }
	public void setPrice(int price) { this.price = price; }
	public void setWeight(int Weight) { this.weight = weight; }

	public String getName() { return this.name; }
	public int getPrice() { return this.price; }
	public int getWeight() { return this.weight; }

}
