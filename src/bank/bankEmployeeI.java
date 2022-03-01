package bank;

import java.util.Scanner;

public class bankEmployeeI extends Data{
	private final String empPasscode = "123321abc";
	private final String empUsername = "admin123";
	String option;
	
	

	public void runEmp(Scanner s)
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
	}
	public void runOptions(Scanner s)
	{
		System.out.println("Please choose from the following options");
		System.out.println("1: Approve account -- 2: Withdraw from an account");
		System.out.println("3-Deposit into an account -- 4: Transfer funds ");
		String option = s.nextLine();
		
		switch(option)
		{
		case "1": //approve account
			break;
		case "2": // withdraw
			break;
		case "3" : //depsoit
			break;
		case "4": //withdraw and deposit
			break;
		default: System.out.println("entry not valid try again"); runOptions(s);
			
		
		}
	}
}
