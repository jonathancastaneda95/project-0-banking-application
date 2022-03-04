package bank;

import java.util.Scanner;

public class BankEmployee extends Data{
	Scanner emp = new Scanner(System.in);
	private static String employeeUN ="employee123";
	private static String employeePass = "bank123";
 
	

	public void runEmp(Scanner emp)
	{
		System.out.println("Please enter employee username ");
		String tempEmployeeUN= emp.nextLine();
		System.out.println("Please enter admin passcode");
		String tempEmployeePass= emp.nextLine();
		
		if(tempEmployeeUN.equals(employeeUN)&& tempEmployeePass.equals(employeePass))
		{
			runEmpOptions(emp);
		}
		else
		{
			System.out.println("User name and passcode not correct try again");
			System.out.println("----------------");
			System.out.println("----------------");

			runEmp(emp);
		}
		return;
	}
	
	public static void runEmpOptions(Scanner emp)
	{
		System.out.println("Please choose from the following options");
		System.out.println("__________________________________");
		System.out.println("1: Approve account");
		System.out.println("2: to view account info");
		System.out.println("__________________________________");
		
		String option = emp.nextLine();
		
		switch(option)
		{
		case "1": apprroveAccountEmp();
			break;
		case "2": printAccountInfoEmp();
			break;
		default: System.out.println("entry not valid try again"); runEmpOptions(emp);
			
		
		}
		return;
	}
	public static void apprroveAccountEmp()
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
		System.out.println("Account not found please try again");
		return;

	}	
	public static void printAccountInfoEmp()
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
				System.out.println("________________________________________________");
				System.out.println("Name: " + ap.name);
				System.out.println("Last name: " + ap.lastName);
				System.out.println("Name of Joint holder: " + ap.nameJoint);
				System.out.println("Last Name of Joint holder: "+ap.lastNameJoint);
				System.out.println("Account number: "+ap.accountNumber);
				System.out.println("Account balance: "+ap.balance);
				System.out.println("Account Approved?: "+ap.approved);
				System.out.println("Account username: "+ap.userN);
				System.out.println("________________________________________________");
				return;

			}
		}
		System.out.println("Account info not found, please try again");
		return;
	}
}

