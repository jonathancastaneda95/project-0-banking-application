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
		
		accountsNeedApproval.add(ac);
		

	}
	public void createJointAccount()
	{
		Account ac = new Account(this.name, this.lastName,this.nameJ, this.lastNameJ, this.username,this.password,this.balance);
		
		accountsNeedApproval.add(ac);

		

	}
	

	public void run(Scanner s)
	{
		boolean existingAccount= false;
		System.out.println("Hello, to create an account, please enter your first name");
		String tempName = s.nextLine();
		
		System.out.println("Please enter your last name");
		String tempLN= s.nextLine();
		
		System.out.println("Will there be a second person on the account?      enter yes or no");
		String tempAnswer = s.nextLine();

		if(tempAnswer.equalsIgnoreCase("no"))
		{
		System.out.println("Please enter a username, must be atleast 6 characters");
		String tempUN = s.nextLine();
		while(tempUN.length()<6)
			{
				System.out.println("Username must be over 6 characters in length");
				System.out.println("Please try again");
				tempUN = s.nextLine();
			}
		if(tempUN.length()>=6)
		{
			
			for(Account a: accounts)
			{
				
				if(a.userN.equals(tempUN))
				{
					
					existingAccount=true;
				}
			}
			if(!existingAccount)
			{
				System.out.println("Please enter your password");
				System.out.println("***Must be between 6 and 12 charters in length***");
				String tempPass = s.nextLine();
				if(tempPass.length()>=6&&tempPass.length()<=12)
					{
					System.out.println("Please enter you initial deposit ammount");
					this.balance= Integer.parseInt(s.nextLine());
					System.out.println("Thank you, account approval can take up to 24 hours");
					
					this.name= tempName;
					this.lastName= tempLN;
					this.username=tempUN;
					this.password=tempPass;
					
					createAccount();
					}else {
						while(tempPass.length()<=6&&tempPass.length()>=12)
						{
							System.out.println("Password does not meet requirments, please try again");
							System.out.println("***Must be between 6 and 12 charters in length***");
							tempPass = s.nextLine();
						}
						System.out.println("Please enter you initial deposit ammount");
						this.balance= Integer.parseInt(s.nextLine());
						System.out.println("Thank you, account approval can take up to 24 hours");
						
						this.name= tempName;
						this.lastName= tempLN;
						this.username=tempUN;
						this.password=tempPass;
					}
			}	
			
		}
		

		
		
		}
		else
		{
			System.out.println("Please enter joint account holder's first name");
			String tempNameJ = s.nextLine();
			System.out.println("Please enter joint account holder's last name");
			String tempLastNameJ= s.nextLine();
			System.out.println("Please enter a username, must be atleast 6 characters");
			String tempUN = s.nextLine();
			if(tempUN.length()>=6)
			{
				
				for(Account a: accounts)
				{
					
					if(a.userN.equals(tempUN))
					{
						
						existingAccount=true;
					}
				}
				if(!existingAccount)
				{
					System.out.println("Please enter your password");
					System.out.println("***Must be between 6 and 12 charters in length***");
					String tempPass = s.nextLine();
					if(tempPass.length()>=6&&tempPass.length()<=12)
						{
						System.out.println("Please enter you initial deposit ammount");
						this.balance= Integer.parseInt(s.nextLine());
						System.out.println("Thank you, account approval can take up to 24 hours");
						
						this.name= tempName;
						this.nameJ=tempNameJ;
						this.lastName= tempLN;
						this.lastNameJ=tempLastNameJ;
						this.username=tempUN;
						this.password=tempPass;
						
						createJointAccount();
						}else {
							while(tempPass.length()<=6&&tempPass.length()>=12)
							{
								System.out.println("Password does not meet requirments, please try again");
								System.out.println("***Must be between 6 and 12 charters in length***");
								tempPass = s.nextLine();
							}
							System.out.println("Please enter you initial deposit ammount");
							this.balance= Integer.parseInt(s.nextLine());
							System.out.println("Thank you, account approval can take up to 24 hours");
							
							this.name= tempName;
							this.nameJ=tempNameJ;
							this.lastName= tempLN;
							this.lastNameJ=tempLastNameJ;
							this.username=tempUN;
							this.password=tempPass;
							createJointAccount();
						}
				}	
				
			}
			
	}
	
	}
}
