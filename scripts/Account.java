
public class Account extends bankMain {

	double balance = 0;
	String accountName;
	String accountId;
	
	Account(String name, String id, double balance){
		accountName = name;
		accountId = id;
		this.balance = balance;
		
	}
	void deposit(double amount) {
		if(amount != 0) {
			balance = balance + amount;
			System.out.println("Successfully deposited: $"+amount);
			System.out.println("Your balance is now: $"+balance);
			System.out.println("**************************************");
		} else {
			System.out.println("You cannot make a deposit of $0");
			System.out.println("**************************************");
		}
		
	}
}
