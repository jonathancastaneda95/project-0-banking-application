package bank;

import java.util.Scanner;

public class BankEmployee extends Data{
	Scanner emp = new Scanner(System.in);
	private static String employeeUN ="employee123";
	private static String employeePass = "bank123";
 
	

	public void runEmp(Scanner emp)
	{
		System.out.println("Please enter admin username ");
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
		System.out.println("1: Approve account -- 2: to view account info");
		
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
				apprroveAccountEmp();
			}
		}
		return;

	}	
	public static void printAccountInfoEmp()
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
}
