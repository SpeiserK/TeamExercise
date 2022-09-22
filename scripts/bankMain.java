
public class bankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account user1 = new Account("Chadwick P.", "BA001", 6900);
		Account user2 = new Account("Mike Wazowski", "BA002", 0);
		
		
		user1.deposit(100000);
		//user1.withdraw(6900);
		
		user2.deposit(400);
		//user2.withdraw(401);
	}

}
