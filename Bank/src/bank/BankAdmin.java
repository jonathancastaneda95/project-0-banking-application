package bank;

import java.util.Scanner;

public class BankAdmin extends Data{
	private static final String empPasscode = "123321abc";
	private static final String empUsername = "admin123";
	String option;
	
	public static void printAccountInfo()
	{
		@SuppressWarnings("resource")
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
				Menu.listAccountInfo(ap);
				return;

			}
		}
		System.out.println("Account info not found, please try again");
		return;
	}
	public static void apprroveAccount()
	{
		System.out.println("The following accounts need approval");
		System.out.println("************************");
		for (Account a:accountsNeedApproval)
		{
			System.out.println(a.name +" " +a.lastName + "- Username: "+ a.userN);
		}
		System.out.println("************************");
		@SuppressWarnings("resource")
		Scanner aA = new Scanner(System.in);
		System.out.println("Please enter the first name for the account holder");
		String tempName = aA.nextLine();
		System.out.println("Please enter account holder's last name");
		String tempLastName = aA.nextLine();
		for(Account ap: accountsNeedApproval)
		{
			System.out.println("System is checking");
			if (ap.name.equals(tempName) && ap.lastName.equals(tempLastName))
			{
				System.out.println("Please asign a 6 digit account number");
				String tempAN = aA.nextLine();
				for(Account an:accounts)
				{
					while(an.accountNumber.equals(tempAN)) {
						System.out.println("Account number already exists, please try again");
						System.out.println("Please asign a 6 digit account number");
						tempAN = aA.nextLine();
						for(Account loop:accounts)
						{
							if(loop.accountNumber.equals(tempAN))
									{
										tempAN=an.accountNumber;
									}
						}
					}
				}
				
				while(tempAN.length()!= 6)
				{
					System.out.println("Account number not valid");
					System.out.println("Please asign a 6 digit account number");
					tempAN = aA.nextLine();
				}
				
				ap.accountNumber=tempAN;
				ap.approved=true;
				System.out.println("Account has been approved");
				Data.accountsNeedApproval.remove(ap);
				Data.accounts.add(ap);
				Data.serialize();
				return;
			
			}
			
		}
		System.out.println("Account not found, please try again");
		return;

	}
	public static void withdraw ()
	{
		System.out.println("***********************");
		double tempBalance;
		@SuppressWarnings("resource")
		Scanner wd = new Scanner(System.in);
		System.out.println("Please enter account number for the account you with to withdraw from");
		String tempAN = wd.nextLine();
		for(Account wac: accounts)
		{
			if (tempAN.equals(wac.accountNumber)&& wac.approved)
			{
				System.out.println("Please enter amount to withdraw");
				double wAmmount = wd.nextDouble();
				tempBalance=wac.balance-wAmmount;
				if(tempBalance>0) {
			
					if(wAmmount>0)
						{	
				
						//switch(tempBalance)
						wac.balance= wac.balance-wAmmount;
						wac.history.add("Withdraw of :"+ String.valueOf(wAmmount)+" Balance: "+ String.valueOf(wac.balance));
						System.out.println("The new balance for account: " + wac.accountNumber + " is: " +wac.balance);
						Data.serialize();
						return;
						}
						else 
						{
							while(wAmmount<0) 
							{
								System.out.println("Ammount can not be less than zero");
								System.out.println("Please enter amount to withdraw");
								wAmmount = wd.nextDouble();
								if(wAmmount>0) {
								wac.balance= wac.balance-wAmmount;
								System.out.println("The new balance for account: " + wac.accountNumber + " is: " +wac.balance);
								Data.serialize();
								return;
								}
							}
						}
					}
					else
					{
						System.out.println("Non sufficient funds");
						withdraw();
					}
			}
			else
			{
				
			}
			
		}
		return;
	}
	public static void deposit ()
	{
		System.out.println("***********************");

		@SuppressWarnings("resource")
		Scanner wd = new Scanner(System.in);
		System.out.println("Please enter account number for the account you with to deposit into");
		String tempAN = wd.nextLine();
		for(Account wac: accounts)
		{
			if (tempAN.equals(wac.accountNumber)&& wac.approved)
			{
				System.out.println("Please enter amount to deposit");
				double dAmmount = wd.nextDouble();
				if(dAmmount>0) {
				wac.balance= wac.balance+dAmmount;
				wac.history.add("Deposit of :"+ String.valueOf(dAmmount)+" Balance: "+ String.valueOf(wac.balance));
				System.out.println("The new balance for account: " + wac.accountNumber + " is: " +wac.balance);
				Data.serialize();
				return;
				}else {
					while(dAmmount<0) {
						System.out.println("Ammount can not be less than zero");
						System.out.println("Please enter amount to deposit");
						dAmmount = wd.nextDouble();
						if(dAmmount>0) {
						wac.balance= wac.balance+dAmmount;
						wac.history.add("Deposit of :"+ String.valueOf(dAmmount)+" Balance: "+ String.valueOf(wac.balance));
						System.out.println("The new balance for account: " + wac.accountNumber + " is: " +wac.balance);
						Data.serialize();

						return;
					}
				}
				return;
			}
			}		
			else
			{
			}
		}
		return;
	}
	public static void transfer()
	
	{
		System.out.println("***********************");

		boolean  firstAccountFound =false;
		@SuppressWarnings("resource")
		Scanner tra=new Scanner(System.in);
		System.out.println("Please enter the account number from which you wish to transfer from");
		String tempANfrom = tra.nextLine();
		System.out.println("Please enter the account number from which you wish to transfer to");
		String tempANto = tra.nextLine();
		
		for(Account tfrom: accounts)
		{
			
			if (tempANfrom.equals(tfrom.accountNumber)&& tfrom.approved){
				firstAccountFound = true;
			}else{
				firstAccountFound=false;
			}
			if(firstAccountFound)
			{
				System.out.println("Please enter the amount you would like to transfer");
				double tempAmmountfrom = Double.parseDouble(tra.nextLine());
				double tempBalance = tfrom.balance-tempAmmountfrom;
				if(tempBalance > 0 )
				{
					
					for(Account tto: accounts)
					{
						if (tempANto.equals(tto.accountNumber)&& tto.approved)
						{
							tfrom.balance=tempBalance;
							tfrom.history.add("Transfer out of :"+ String.valueOf(tempAmmountfrom)+" Balance: "+ String.valueOf(tfrom.balance));
							tto.balance = tto.balance+tempAmmountfrom;
							tto.history.add("Transfer in of :"+ String.valueOf(tempAmmountfrom)+" Balance: "+ String.valueOf(tto.balance));
							System.out.println("The new balance for " + tto.name +" " + tto.lastName + "is: " + tto.balance);
							System.out.println("The new balance for " +tfrom.name +": " + tfrom.balance)  ;
							
							Data.serialize();

							return;
						}
						else
						{
						}
					}
					
				}
				else
				{
					System.out.println("Account does not have sufficient funds, please try again");
				}
			}
		}
		
		System.out.println("Account transfer not succesful, please try again");
		transfer();

		
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
			
			return;
		}
		return;
	}
	public static void runOptions(Scanner s)
	{
		Menu.adminOptions();
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
		case "6": deleteAccount();
			break;
		default: System.out.println("entry not valid try again"); runOptions(s);
			
		
		}
		return;
	}
	public static void deleteAccount()
	{
		System.out.println("***********************");

		@SuppressWarnings("resource")
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
				System.out.println("Please enter account number to procede with deleting account");
				String tempAN = aA.nextLine();
				if(tempAN.equals(ap.accountNumber)) {
					accounts.remove(ap);
					System.out.println("Account has been deleted");
					Data.serialize();
				}
				return;
			
			}
			
	}
		System.out.println("Unable to delete account");
	}
}
