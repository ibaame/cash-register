
import java.util.Scanner;

public class Read  {

	 /* -------------------- read value from user => String , Integer , Double  --------------------- */
	
	public static String Str(){
		Scanner input = new Scanner(System.in);
		String value = input.nextLine();
		return value;
	}
	
	public static int Int(){
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		return value;
	}
	
	public static double Double(){
		Scanner input = new Scanner(System.in);
		double value = input.nextDouble();
		return value;
	}
	 
}
