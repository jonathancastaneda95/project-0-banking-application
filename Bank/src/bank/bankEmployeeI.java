package bank;

import java.util.Scanner;

public class bankEmployeeI extends Data{
	private static final String empPasscode = "123321abc";
	private static final String empUsername = "admin123";
	String option;
	
	
	public static void apprroveAccount()
	{
		Scanner aA = new Scanner(System.in);
		System.out.println("Please enter the first name for the account holder");
		String tempName = aA.nextLine();
		System.out.println("Please enter account holder's last name");
		String tempLastName = aA.nextLine();
		for(Account ap: accounts)
		{
			System.out.println("System is checking");
			if (ap.name.equals(tempName) && ap.lastName.equals(tempLastName))
			{
				System.out.println("Please asign a 6 digit account number");
				String tempAN = aA.nextLine();
				
				while(tempAN.length()!= 6)
				{
					System.out.println("Account number not valid");
					System.out.println("Please asign a 6 digit account number");
					tempAN = aA.nextLine();
				}
				
				
			
			}
			else
			{
				System.out.println("Account not found, please try again");
				apprroveAccount();
			}
		}
		System.out.println("This is where program goes");

	}
	public static void withdraw ()
	{
		Scanner wd = new Scanner(System.in);
		System.out.println("Please enter account number for the account you with to withdraw from");
		String tempAN = wd.nextLine();
		for(Account wac: accounts)
		{
			if (tempAN.equals(wac.accountNumber)&& wac.approved)
			{
				System.out.println("PLease enter amount to withdraw");
				double wAmmount = wd.nextDouble();
				wac.balance= wac.balance-wAmmount;
				System.out.println("The new balance for account: " + wac.accountNumber + " is: " +wac.balance);
			}
			else
			{
				System.out.println("Account not found or not active please try again");
				withdraw();
			}
			return;
		}
	}
	public static void runEmp(Scanner s)
	{
		System.out.println("Please enter admin username ");
		String tempEmpUN= s.nextLine();
		System.out.println("Please enter admin passcode");
		String tempEmpPass= s.nextLine();
		
		if(tempEmpUN.equals(empUsername)&& tempEmpPass.equals(empPasscode))
		{
			runOptions(s);
		}
		else
		{
			System.out.println("User name and passcode not correct try again");
			System.out.println("----------------");
			System.out.println("----------------");

			runEmp(s);
		}
		return;
	}
	public static void runOptions(Scanner s)
	{
		System.out.println("Please choose from the following options");
		System.out.println("1: Approve account -- 2: Withdraw from an account");
		System.out.println("3-Deposit into an account -- 4: Transfer funds ");
		String option = s.nextLine();
		
		switch(option)
		{
		case "1": apprroveAccount();
			break;
		case "2":  withdraw();
			break;
		case "3" : //depsoit
			break;
		case "4": //withdraw and deposit
			break;
		default: System.out.println("entry not valid try again"); runOptions(s);
			
		
		}
	}
}
