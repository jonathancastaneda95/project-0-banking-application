package bank;

import java.util.Scanner;

public class userI extends Data {
	String name;
	String lastName;
	String nameJ;
	String lastNameJ;
	String username;
	String password;
	double balance;
	
	public void createAccount()
	{
		Account ac = new Account(this.name, this.lastName,this.username,this.password,this.balance);
		accounts.add(ac);
	}
	public void createJointAccount()
	{
		Account ac = new Account(name, lastName,nameJ, lastNameJ, username,password,balance);
		accounts.add(ac);
	}
	

	public void run(Scanner s)
	{
		System.out.println("Hello, to create an account, please enter your first name");
		String tempName = s.nextLine();
		//System.out.println(tempName);
		
		System.out.println("Please enter your last name");
		String tempLN= s.nextLine();
		
		System.out.println("Will there be a second person on the account?      enter yes or no");
		String tempAnswer = s.nextLine();
	
		
		
		if(tempAnswer.equalsIgnoreCase("no"))
		{
		System.out.println("Please enter a username, must be 6 to 12 characters long");
		String tempUN = s.nextLine();
		
		
		//check to see if username exists 
		System.out.println("Please enter your password (Must contain atleast 1 special character and be between 6 and 12 charters in length");
		String tempPass = s.nextLine();
		// check to see if pass word is correct
		System.out.println("Please enter you initial deposit ammount");
		this.balance= Integer.parseInt(s.nextLine());
		
		this.name= tempName;
		this.lastName= tempLN;
		this.username=tempUN;
		this.password=tempPass;
		
		createAccount();
		
		
//		for(Account obj: accounts)
//		System.out.println(obj.balance);
		
		
		}
		else
		{
			System.out.println("Please enter second account holders fist name");
			String tempJname = s.nextLine();
			
			System.out.println("Please enter second account holders last name");
			String tempJlastname = s.nextLine();
			
			System.out.println("Please enter a username, must be 6 to 12 characters long");
			String tempUN = s.nextLine();
			
			
			//check to see if username exists 
			System.out.println("Please enter your password (Must contain atleast 1 special character and be between 6 and 12 charters in length");
			String tempPass = s.nextLine();
			// check to see if pass word is correct
			System.out.println("Please enter you initial deposit ammount");
			balance= Integer.parseInt(s.nextLine());
			
			tempName=name;
			tempLN= lastName;
			tempUN=username;
			tempPass=password;
			tempJname= nameJ;
			tempJlastname=lastNameJ;
			
			createJointAccount();
			
			for(Account obj: accounts)
				System.out.println(obj.balance);
		}
		
		return;
	}
	
	
}
