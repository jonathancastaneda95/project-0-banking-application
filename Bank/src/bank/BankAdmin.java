package bank;

import java.util.Scanner;

public class BankAdmin extends Data{
	private static final String empPasscode = "123321abc";
	private static final String empUsername = "employee123";
	String option;
	
	public static void printAccountInfo()
	{
		Scanner pA = new Scanner(System.in);
		System.out.println("Please enter the first name for the account holder");
		String tempName = pA.nextLine();
		System.out.println("Please enter account holder's last name");
		String tempLastName = pA.nextLine();
		for(Account ap: accounts)
		{
			System.out.println("System is checking");
			if (ap.name.equals(tempName) && ap.lastName.equals(tempLastName))
			{
				System.out.println("Name: " + ap.name);
				System.out.println("Last name: " + ap.lastName);
				System.out.println("Name of Joint holder: " + ap.nameJoint);
				System.out.println("Last Name of Joint holder: "+ap.lastNameJoint);
				System.out.println("Account number: "+ap.accountNumber);
				System.out.println("Account balance: "+ap.balance);
				System.out.println("Account Status: "+ap.approved);
				System.out.println("Account username: "+ap.userN);

			}
		}
		return;
	}
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
				
				ap.accountNumber=tempAN;
				ap.approved=true;
				System.out.println("Account has been approved");
				return;
			
			}
			else
			{
				System.out.println("Account not found, please try again");
				apprroveAccount();
			}
		}
		return;

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
	public static void deposit ()
	{
		Scanner wd = new Scanner(System.in);
		System.out.println("Please enter account number for the account you with to deposit into");
		String tempAN = wd.nextLine();
		for(Account wac: accounts)
		{
			if (tempAN.equals(wac.accountNumber)&& wac.approved)
			{
				System.out.println("PLease enter amount to deposit");
				double dAmmount = wd.nextDouble();
				wac.balance= wac.balance+dAmmount;
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
	public static void transfer()
	
	{
		boolean  firstAccountFound = false;
		Scanner tra=new Scanner(System.in);
		System.out.println("Please enter the account number from which you wish to transfer from");
		String tempANfrom = tra.nextLine();
		System.out.println("Please enter the account number from which you wish to transfer to");
		String tempANto = tra.nextLine();
		
		for(Account tfrom: accounts)
		{
			if (tempANfrom.equals(tfrom.accountNumber)&& tfrom.approved)
			{
				firstAccountFound = true;
			}
			else
			{
				System.out.println("Account to transfer from not found or not active please try again");
				transfer();
			}
			if(firstAccountFound)
			{
				System.out.println("Please enter the amount you would like to transfer");
				double tempAmmountfrom = tra.nextDouble();
				double tempBalance = tfrom.balance-tempAmmountfrom;
				if(tempBalance > 0 )
				{
					tfrom.balance=tempBalance;
					for(Account tto: accounts)
					{
						if (tempANfrom.equals(tto.accountNumber)&& tto.approved)
						{
							tto.balance = tto.balance+tempAmmountfrom;
							System.out.println("The new balance for " + tto.name +" " + tto.lastName + "is: " + tto.balance);
						}
						else
						{
							System.out.println("Account to tranfer to not found or not active please try again");
							transfer();

						}
					}
					
				}
				else
				{
					System.out.println("Account does not have sufficient funds, please try again");
				}
			}
		}
		
		return;
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
		System.out.println("5 to view account info");
		String option = s.nextLine();
		
		switch(option)
		{
		case "1": apprroveAccount();
			break;
		case "2":  withdraw();
			break;
		case "3" : deposit();
			break;
		case "4": transfer();
			break;
		case "5": printAccountInfo();
			break;
		default: System.out.println("entry not valid try again"); runOptions(s);
			
		
		}
		return;
	}
}
