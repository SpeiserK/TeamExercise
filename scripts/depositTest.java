import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import junit.framework.Assert;

public class depositTest {

	@Test
	public void test() {
		
		//bankMain test = new bankMain();
		
		
		
		int d = 10;
		Account test = new Account("test", "testid", 0);
		test.deposit(d);
		
		Assert.assertEquals((int) test.balance, d);
		
		
	}

}
