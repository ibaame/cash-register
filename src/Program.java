

public class Program {

	public static void main(String[] args)
	{		
		boolean loop = true;
        while (loop)
        {
      	  System.out.println("\n=========================[Welcome to Store ]=========================\n");
      	  System.out.println("(1) start.");
      	  System.out.println("(0) Exit.");
      	  System.out.print("\nEnter Number : ");
            int chose = Read.Int();
            
            switch (chose)
            {
                case 1:  // Edit Product
                    Menu menu = new Menu();
                    menu.main();
                    break;
                case 0: // Exit
                    loop = false;
                    break;
                default: // wrong chose
                    loop = true;
                    break;
            }
        }  
        System.out.println("\n==================================\n");
        System.out.println("Thank you for use my Program");
	}

}
