import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class withdrawTest {

	@Test
	public void test() {

		
		int d = 10;
		Account test = new Account("test", "testid", 20);
		test.withdraw(d);
		
		Assert.assertEquals((int) test.balance, d);
	}

}
