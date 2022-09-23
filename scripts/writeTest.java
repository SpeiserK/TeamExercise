import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;


class writeTest {

	@Test
	void test() throws IOException {
		String userInput = "BA1", last = null, line;
		boolean trigger = true;
		while (trigger) {
			System.out.println("login to existing account, enter Account number: BA1");

			
			//check for account number in 'database'
			//again check this file for bank account info
			BufferedReader inp = new BufferedReader(new FileReader("scripts/BankAccounts.txt"));
		    last = null;
		    while ((line = inp.readLine()) != null) { 
		        last = line;
		        if (last.substring(last.lastIndexOf(" ") + 1).equals(userInput)) break;
		    }
		    System.out.println("Account details:" + line);
		    System.out.println("**************************************");
			//if account no. not found
			if (line == null) {
				System.out.println("no account matches that number, please try again");
			} else {
				trigger = false;
				inp.close();
			}
			
		}
		assertTrue(last != null);
	}

}
