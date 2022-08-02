
import java.util.ArrayList;

public class Process {
	
	private static int counter;
	private ArrayList<Order> orders;
	private double total;
	private double taxation;
	
	public Process(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public double totalCost() {
		total = 0;
		for(Order order : orders)
			total += order.getQuantity() * twoDigit(order.getPrice());
		return total;
	}

	public double tax()
    {
        taxation = totalCost() * 0.15;
        return taxation;
    }
	
	public double totalWithTax() {
		return total + taxation;
	}
	
	public String allOrders() {
		String allOrdersInCart = "";
		allOrdersInCart = "ID    Name    Quantity    Price for one piece\n________________________________________________";
		int i = 0;
		for(Order order : orders) 
			allOrdersInCart += "\n" + (++i) + "      "+ order.toString();
		return allOrdersInCart;
	}
	
	public static String randomPass() {
		int num = (int)(1000 + Math.random() * 9000);  // 1000 to 9999
        char letter = (char)(65 + Math.random() * 26 );   // A to Z
        String pass = String.valueOf(letter) + String.valueOf(num);
        return pass;
    }
	  
	public static int counterInvoice() {
		counter++;
		return counter;
	}  
	
	public static double twoDigit(double num) {
		 num =  (((int)(num*100))/100d);
		 return num;
	 }
	
}
