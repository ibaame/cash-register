
import java.util.ArrayList;

public class Menu {

	private ArrayList<Order> orders;
	private Process process;
	private Order order;
	private boolean isEmpty;// check if a cart is empty or not
	
	public Menu() {
		orders = new ArrayList<>();
		process = new Process(orders);
		isEmpty = true; 
	}
	
	public void main() {
		
		boolean loop = true;
		while(loop) {
			 System.out.println("\n=========================[select your chose]=========================\n");
	         System.out.println("(1) Add order.");
	         System.out.println("(2) Update order.");
	    	 System.out.println("(3) Show Invoice.");
	    	 System.out.println("(4) Delete order.");
	    	 System.out.println("(5) Pay.");
	         System.out.println("(0) Exit.");
	         System.out.print("\nEnter Your Chose: ");
	         int chose = Read.Int();
	              
	         if(chose == 1 ) {
	        	 addOrder();
	        	 
	         }
	         else if(chose == 2 && isEmpty == false) 
	        	 updateOrder();
	         else if(chose == 3 && isEmpty == false)
	        	 invoice();
	         else if(chose == 4 && isEmpty == false) 
	        	 deleteOrder();
	         else if(chose == 5 && isEmpty == false) 
	        	 pay();
	         else if(isEmpty == true && (chose >= 2 && chose <= 5)) {
	        	 System.out.println("\n==============================[Message]==============================\n");
            	 System.out.println("There is no order, must add order");
	         }
	         else if(chose == 0) 
	        	 loop = false;
	         else {
	        	 System.out.println("\n==============================[Message]==============================\n");
            	 System.out.println("wrong chose, again");
	         }
		}
		
	}

	private void addOrder() {
		System.out.println("\n=============================[add prouct]============================\n");
   	 	System.out.print("Name Product: ");
   	 	String name = Read.Str();
        System.out.print("Quantity: ");
        int quantity= Read.Int();
        System.out.print("Cost product to piece: ");
        double price = Read.Double();
        
        order = new Order(name, quantity, price);
        orders.add(order);
        isEmpty = false;
	}
	
	private void updateOrder() {
		 System.out.println("\n===========================[Update Product]==========================\n");
    	 System.out.print("Enter ID order to update: ");
    	 int IDOrder = Read.Int();
    	 IDOrder--;// because index start from 0
         if(IDOrder >= 0 && IDOrder < orders.size() ) {
        	 order = orders.get(IDOrder);
        	 System.out.print("Name Product: ");
        	 order.setName(Read.Str());
             System.out.print("Quantity: ");
             order.setQuantity(Read.Int());
             System.out.print("Cost product for one piece: ");
             order.setPrice(Read.Double());
 		}
 		else {
 			System.out.println("product number [ " + (++IDOrder) + " ] doesn't exist"  );
 		}
	}
	
	private void invoice() {
		System.out.println("\n==============================[Invoice]==============================\n");
		System.out.println("ID    Name    Quantity    Price for one piece\n_________________________________________________");
		int i = 0;
		for(Order iorder : orders) 
			System.out.println( (++i) + "      "+ iorder.toString());
		
		System.out.println("_________________________________________________");
		System.out.println("Total Cost: " + Process.twoDigit(process.totalCost()) + "$");
        System.out.println("Tax: " +Process.twoDigit(process.tax())+ "$");// Tax 15%
        System.out.println("Total Cost With Tax: " +Process.twoDigit(process.totalWithTax())+ "$");	
	}
	
	private void deleteOrder() {
		System.out.println("\n===========================[Delete element]==========================\n");
		System.out.print("Enter ID of order: ");
		int IDOrder = Read.Int();
		IDOrder--; // because index start from 0

		if(IDOrder >= 0 && IDOrder < orders.size() ) {
			String check = process.randomPass();
			System.out.println("password => " + check);
            System.out.print("Enter password: ");
            String pass = Read.Str();
            
            if(check.equals(pass)) {
            	orders.remove(IDOrder);
    			if(orders.size() == 0)
    				isEmpty = true;		
            }
            else
            	System.out.println("password is wrong, again");
		}
		else 
			System.out.println("product number [ " + (++IDOrder) + " ] doesn't exist"  );		
	}
	
	private void pay() {
		Payment pay = new Payment(process.allOrders(),Process.twoDigit(process.totalCost()),Process.twoDigit(process.tax()));
		pay.pay();
		orders.clear();
		isEmpty = true;
	}
	
}
