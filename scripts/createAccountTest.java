import static org.junit.Assert.*;


import org.junit.Test;

public class createAccountTest extends bankMain{

	@Test
	public void test(){
		String userName = "steve",userId = "BA15";
		double userBal = 5000;
		Account test = new Account(userName,userId,userBal);
		Account user = bankMain.createAccount(userName, userBal, 15);
		assertTrue(test.accountName==user.accountName);
		assertTrue(test.accountId==user.accountId);
		assertTrue(test.balance==user.balance);
	}
}
