
import java.util.ArrayList;

public class Payment {

	private ArrayList<User> users;
	private int accountNum;
	private User user;
	
	private String allOrder;
	private double totalCost;
	private double tax;
	private double totalWithTax;
	
	public Payment(String allOrder, double totalCost, double tax) {
		Database database = new Database();
		users = database.usersInfo();
		user = users.get(accountNum);
		this.allOrder = allOrder;
		this.totalCost = totalCost;
		this.tax = tax;
		totalWithTax = totalCost + tax;
	}
	
	public void pay() {
		boolean loop = true;
        while (loop)
        {
            System.out.println("\n=========================[select paymen way]=========================\n");
            System.out.println("pay by Cash or Card ?");
            System.out.println("(1) Cash");
            System.out.println("(2) Card");
            System.out.print("\nEnter Number: ");
            int Choce = Read.Int();
            if (Choce == 1)
            {
                cash();
                loop = false;
            }
            else if (Choce == 2)
            {
           	 System.out.println("\n=======================[select account for pay]=====================\n");
           	 System.out.print("Enter your account number: ");
                accountNum = Read.Int();
                --accountNum;
                
                if(accountNum >= 0 && accountNum < users.size()) {
               	 card();
                    loop = false;
                }
                else
               	 System.out.println("account number [ " + (++accountNum) + " ] doesn't exist");
            }
            else
                loop = true;
        }
	}
	 	 
	private void cash() {
		System.out.println("\n================================[cash]===============================\n");
		System.out.println(allOrder);
		System.out.println("\n======================[#"+ Process.counterInvoice() + "]======================\n");
        System.out.println("\nValue of products: " + totalCost + "$");
        System.out.println("Tax: " + tax  + "$");
        System.out.println("Value of products With Tax: " + Process.twoDigit(totalWithTax) + "$"  );
        System.out.print("The amount given: ");
        double given = Read.Double();
        double rest = given - Process.twoDigit(totalWithTax);
        System.out.println("The rest amount: " + Process.twoDigit(rest));
	}
	
	private void card() {
		boolean loop = true;
        while (loop)
        {
       	 System.out.println("\n==============================[sign in]=============================\n");
       	 System.out.print("Enter User: ");
            String userName = Read.Str();
            System.out.print("Enter password Number: ");
            int password = Read.Int();

            if ((user.getPassword() == password) && ( user.getUserName().equals(userName)))
            {
           	 boolean check = true;
                while (check)
                {
               	 System.out.println("\n==========================[check sign in]==========================\n");
                    String Random = Process.randomPass();

                    System.out.println("password => " + Random);
                    System.out.print("Enter password: ");
                    String pass = Read.Str();
                    if (pass.equals(Random))
                    {
                   	 System.out.println("\n================================[card]===============================\n");
                        cardInfo();
                        loop = false;
                        check = false;
                    }
                    else {
                   	 System.out.println("*Message: password is wrong, again");
                   	 check = true; 
                    }   
                }
            }
            else
            {
           	 System.out.println("\n=========================[wrong Sign in]=========================\n");
           	 wrongSignIn();
                loop = true;
            }
        }
	}
	 
	private void cardInfo() {
		 System.out.println(user.toString());
		 System.out.println("\n================================================");
		 System.out.println(allOrder);
		 System.out.println("\n======================[#"+ Process.counterInvoice() + "]======================\n");
		 System.out.println("value of products: " + totalCost + "$");
		 System.out.println("value of products With Tax: " + Process.twoDigit(totalWithTax)  + "$");
		 System.out.println("Card Balance: " + user.getBalance() + "$");
		 double rest = user.getBalance() - Process.twoDigit(totalWithTax);
         System.out.println("The rest amount in card Balance: " +Process.twoDigit(rest) + "$" );
	}
	
	private void wrongSignIn() {
		 boolean loop = true;
         while(loop) {
        	 System.out.println("*Message: password or user name is wrong\n");
    		 System.out.println("(1) if forget password.");
    		 System.out.println("(2) if forget User.");
    		 System.out.println("(3) Sign in again.");
    		 System.out.print("\nEnter Number: ");
             int Forget = Read.Int();
        	 
        	 if (Forget == 1)
             {
            	 System.out.println("\n=========================[Your passwrod]=========================\n");
            	 System.out.println("[ "  + user.getPassword() + " ]");
            	 loop = false;
             }
             else if (Forget == 2)
             {
            	 System.out.println("\n=========================[Your user name]=========================\n");
            	 System.out.println("[ " +  user.getUserName()+ " ]");
            	 loop = false;
             }
             else if (Forget == 3) {
            	 loop = false;
             }
             else
             {
            	 System.out.println("\n===========================[ Message ]===========================\n");
            	 System.out.println("wrong cohse, again");
            	 System.out.println("\n=================================================================\n");
            	 loop = true;
             }
         }
	}

}
