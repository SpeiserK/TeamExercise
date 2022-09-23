import static org.junit.Assert.*;
import org.junit.Test;

public class createAccountTest extends bankMain{

	@Test
	public void test(){
		//get new account details
		String userName = "steve",userId = "BA15";
		double userBal = 5000;
		//make account object
		Account test = new Account(userName,userId,userBal);
		//make account using bankMain method
		Account user = bankMain.createAccount(userName, userBal, 15);
		//test values verifying objection creation
		assertTrue(test.accountName.contentEquals(user.accountName));
		assertTrue(test.accountId.contentEquals(user.accountId));
		assertTrue(test.balance==user.balance);
	}
}
