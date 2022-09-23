import java.util.Scanner;

public class bankMain {

	public static void main(String[] args) {

		
		int menu = 1;
		
		
				//intro Page
		System.out.println("Welcome to Group C Bank! "
				+ "\nIf you are a new customer please enter 1. "
				+ "\nIf you are a returning customer please enter 2. ");
		
		//scan reads next int
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		
		if (key==1) {//create new account
			System.out.println("create new account");
			//TODO: Insert Code Block
		
		};
		if (key==2) {//login to existing account
			System.out.println("login to existing account");
			//TODO: Insert Code Block
		
		} if (key!=1 && key!=2) { System.out.println("invalid Entry");
		}

		// TODO Auto-generated method stub

		Account user1 = new Account("Chadwick P.", "BA001", 6900);
		Account user2 = new Account("Mike Wazowski", "BA002", 0);
		
		
		user1.deposit(100000);
		user1.withdraw(6900);
		
		user2.deposit(400);
		user2.withdraw(401);

	}
}
			
			
		
	


