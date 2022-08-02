
public class User {

	// information for user
	private int accountNum;
	private String userName;
	private int password;
	private String name;
	private String DOB;
	private double balance;
	
	// constructor 
	public User(int accountNum, String userName, int password, String name, String DOB, double balance) {
		this.accountNum = accountNum;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.DOB = DOB;
		this.balance = balance;
	}

	// Setters and Getters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	// password encryption [ 1234 => 1**4]
	public String passwordEncryption() {
		char[] pass = String.valueOf(getPassword()).toCharArray();
		String passx = "";
		for(int i = 0 ; i < pass.length ; i++) {
			if(i == 0 || i == pass.length - 1)
				passx += String.valueOf(pass[i]);
			else
				passx += "*";
		}
		return passx;
	}
	
	// toString 
	@Override
	public String toString() {
		String txt = "--- informations ---\n";
		txt += "\naccount number: " + getAccountNum();
		txt += "\nuser name: " + getUserName();
		txt += "\npassword: " + passwordEncryption();
		txt += "\nname: " + getName();
		txt += "\ndate of birth: " + getDOB();
		txt += "\nbalance: " + getBalance() + "$";
		return txt;
	}
	
}
