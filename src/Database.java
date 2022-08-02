
import java.util.ArrayList;

public class Database { // Database for Users
	
	private ArrayList<User> users ; 
	
	public Database() {
		users = new ArrayList<>();
		main();
	}
	
	/* ----------------------- informations --------------------*/
    // User storage 
	public void main() {
		User u1 = new User(1, "ali7", 4612, "Ali Mohammed Ahmed", "2000/03/06", 7812.92);
		addUser(u1);
		User u2 = new User(1, "khalid23", 9710, "Khalid Ali Mohammed", "1992/09/21", 3468.68);
		addUser(u2);
		User u3 = new User(3, "moh77ed", 6249, "Mohammed hassan omar", "1985/11/09", 4493.55);
		addUser(u3);
		User u4 = new User(4, "1brahim", 2818, "Ibrahim omar abdulwahab", "2001/01/13", 5466.55);	
		addUser(u4);
	}
	
	private void addUser(User user) {
		users.add(user);
	}
	
	public ArrayList<User> usersInfo() {
		return users;
	}

}

