import java.util.Scanner;

public class bankMain {

	public static void main(String[] args) {

		boolean exit = false;
		int userCount = 0;
		Account user = null;
		
				//intro Page
		System.out.println("Welcome to Group C Bank! "
				+ "\nIf you are a new customer please enter 1. "
				+ "\nIf you are a returning customer please enter 2. ");
		
		//scan reads next int
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		
		if (key==1) {
			//update user count	
			userCount++;
			//get initial balance
			System.out.println("Please enter intial deposit amount.");
			double accBal = scan.nextDouble();
			
			//get name
			System.out.println("Please enter your name.");
			scan.nextLine();
			String accName = scan.nextLine();
			//create account
			user = createAccount(accName,accBal,userCount);
	
		};
		if (key==2) {
			//login to existing account
			System.out.println("login to existing account");
			//TODO: Insert Code Block
			//user = signIn();
		} if (key!=1 && key!=2) { 
			System.out.println("invalid Entry");
			exit = true;
		}
		//enter do-while loop so user can withdraw/deposit until done
		do {
			System.out.println("To withdraw money press 1"
					+"\nTo deposit money press 2"
					+"\nTo exit press 0");
			int choice = scan.nextInt();
			if(choice==1) {
				System.out.println("Enter withdraw amount");
				double withNum = scan.nextDouble();
				user.withdraw(withNum);
			}else if(choice==2) {
				System.out.println("Enter deposit amount");
				double depoNum = scan.nextDouble();
				user.deposit(depoNum);
			}else if (choice==0){
				exit = true;
			}else {
				System.out.println("Invalid choice.");
			}
		}while(exit!=true);
	
		//user1.deposit(100000);
		//user1.withdraw(6900);
		
		//user2.deposit(400);
		//user2.withdraw(401);
	}
	
	//create account method
	static Account createAccount(String name,double balance,int count) {
			//make new account object
			Account user = new Account(name,"BA"+count,balance);
			System.out.println("Thank you.");
			System.out.println("Your account name is "+user.accountName+"\nYour account id is "+user.accountId);
			return user;
	}
}
			
			
		
	


