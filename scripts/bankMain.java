import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
public class bankMain {

	public static void main(String[] args) throws IOException {
		//find correct userCount
		BufferedReader input = new BufferedReader(new FileReader("scripts/BankAccounts.txt"));
	    String last = null, line;
	    while ((line = input.readLine()) != null) { 
	        last = line;
	    }
	    String lastToken = last.substring(last.lastIndexOf(" ") + 1);
		input.close();
		
		boolean exit = false;
		int userCount = Integer.parseInt(lastToken.substring(2));
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
			
			String userInput = null;
			boolean trigger = true;
			while (trigger) {
				
				System.out.println("login to existing account, enter Account number:");

				userInput = scan.next();
				
				//check for account number in 'database'
				
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
			
			//read account info using account name, create Account object with appropriate attributes
			user = new Account(last.substring(0,last.indexOf(" ")), userInput, Double.parseDouble(last.substring(last.indexOf(" "), last.lastIndexOf(" "))));
		}; if (key!=1 && key!=2) { 
			System.out.println("invalid Entry");
			exit = true;
		};
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
		
		//save account info
		if(key==2)updateAccount(user.accountName + " " + user.balance + " " + user.accountId, last);
		
		
	
		//user1.deposit(100000);
		//user1.withdraw(6900);
		
		//user2.deposit(400);
		//user2.withdraw(401);
	}
	public static void updateAccount(String newnum, String oldnum) throws IOException {
		
		List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("scripts/BankAccounts.txt"), StandardCharsets.UTF_8));
	
		for (int i = 0; i < fileContent.size(); i++) {
		    if (fileContent.get(i).equals(oldnum)) {
		        fileContent.set(i, newnum);
		        break;
		    }
		}
		Files.write(Paths.get("scripts/BankAccounts.txt"), fileContent, StandardCharsets.UTF_8);
	}

	
	

	//create account method
	static Account createAccount(String name,double balance,int count) {
			//make new account object
			Account user = new Account(name,"BA"+count,balance);
			System.out.println("Thank you.");
			System.out.println("Your account name is "+user.accountName+"\nYour account id is "+user.accountId);
			
			try {
			      
		    	  FileWriter myWriter = new FileWriter("scripts/BankAccounts.txt", true);
		    	  myWriter.append("\n" + user.accountName + " " + user.balance  + " " + user.accountId );
		    	  myWriter.close();
			    } catch (IOException e) {
			    	System.out.println("An error occurred.");
			    	e.printStackTrace();
			    }
			
			return user;
	}
}
			
			
		
	
