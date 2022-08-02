

public class Order {

	private String name ;
	private int quantity ;
	private double price;
	
	public Order(String name , int quantity , double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + "\t" + getQuantity()+ "\t   " + (((int)(getPrice()*100))/100d) + "$";
	}

}
