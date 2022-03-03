package bank;

import java.util.Scanner;

public class AccountLogin extends Data {
	Scanner loginScan = new Scanner(System.in);
	String tempUN;
	String tempPass;
	
	public void login()
	{
		System.out.println("Please enter your username");
		tempUN= loginScan.nextLine();
		System.out.println("Please enter your password");
		tempPass=loginScan.nextLine();
		for(Account log: accounts)
		{
			if (tempUN.equals(log.userN)&&tempPass.equals(log.getPassword()))
			{
			if(log.approved) {
				System.out.println("Please choose from the following options");
				System.out.println("1: Withdraw from an account--2: Deposit into an account");
				System.out.println("3: Print account info ");
				
				String option = loginScan.nextLine();
				
				switch(option)
				{
				case "1":
					System.out.println("Please enter withdraw ammount");
					double tempW= loginScan.nextDouble();
					log.withdraw(tempW);
					return;
				case "2":  
					System.out.println("Please enter deposit ammount");
					double tempD= loginScan.nextDouble();
					log.deposit(tempD);
					return;
				case "3": System.out.println(log.name);
				System.out.println("Name: " + log.name);
				System.out.println("Last name: " + log.lastName);
				System.out.println("Name of Joint holder: " + log.nameJoint);
				System.out.println("Last Name of Joint holder: "+log.lastNameJoint);
				System.out.println("Account number: "+log.accountNumber);
				System.out.println("Account balance: "+log.balance);
				System.out.println("Account Approved?: "+log.approved);
				System.out.println("Account username: "+log.userN);
					return;
				default: System.out.println("entry not valid try again"); login();
					
				
				}
			}else
			{
				System.out.println("Account not approved, please wait for bank to approve");
			}
				
			}
		}
		
		System.out.println("Login unsuccesful");
	}

}
