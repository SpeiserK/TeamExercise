
public class Account extends bankMain {

	double balance = 0;
	String accountName;
	String accountId;
	
	Account(String name, String id, double balance){
		accountName = name;
		accountId = id;
		this.balance = balance;
		
	}
	//deposit function, checks that deposit > 0
	void deposit(double amount) {
		if(amount != 0) {
			balance = balance + amount;
			System.out.println("**************************************");
			System.out.println("Successfully deposited: $"+amount);
			System.out.println("Your balance is now: $"+balance);
			System.out.println("**************************************");
		} else {
			System.out.println("**************************************");
			System.out.println("You cannot make a deposit of $0");
			System.out.println("**************************************");
		}
	}
	//withdraw function, check for sufficient funds in balance
	void withdraw(double amount) {
		if(amount != 0) {
			if(amount > balance) {
				System.out.println("**************************************");
				System.out.println("You do not have the sufficient funds to withdraw: $"+amount);
				System.out.println("Your balance: $"+balance);
				System.out.println("**************************************");
			} else {
				balance = balance - amount;
				System.out.println("**************************************");
				System.out.println("Successfully withdrawn: $"+amount);
				System.out.println("Remaining balance: $"+balance);
				System.out.println("**************************************");
			}
		} else {
			System.out.println("**************************************");
			System.out.println("You cannot withdraw $0");
			System.out.println("**************************************");
		}
	}
}
