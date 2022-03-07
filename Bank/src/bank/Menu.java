package bank;

public class Menu {
	
public static void startUp()
{
	System.out.println("***************************");
	System.out.println("*******Welcome!************");
	System.out.println("***Project 0 Banking*******");
	System.out.println("***************************");
}

public static void mainOptions()
{




	System.out.println("Please choose from the following options");
	System.out.println("__________________________");
	System.out.println("(1) Admin Login ");
	System.out.println("(2) Employee Login ");
	System.out.println("(3) Create Account");
	System.out.println("(4) Login to Account");
	System.out.println("__________________________");
}
public static void listAccountInfo(Account ap)
{
	System.out.println("Name: " + ap.name);
	System.out.println("Last name: " + ap.lastName);
	if(ap.nameJoint != null)
	{
		System.out.println("Name of Joint holder: " + ap.nameJoint);
		System.out.println("Last Name of Joint holder: "+ap.lastNameJoint);
	}
	System.out.println("Account number: "+ap.accountNumber);
	System.out.println("Account balance: "+ap.balance);
	System.out.println("Account Approved?: "+ap.approved);
	System.out.println("Account username: "+ap.userN);
}
public static void adminOptions()
{
	System.out.println("Please choose from the following options");
	
	System.out.println("_______________________________");
	System.out.println("1: Approve Account");
	System.out.println("2: Withdraw from an account");	
	System.out.println("3: Deposit into an account");
	System.out.println("4: Transfer funds");
	System.out.println("5: View account info");
	System.out.println("6: Delete account");
	System.out.println("_______________________________");
}
public static void employeeOptions()
{
	System.out.println("Please choose from the following options");
	System.out.println("__________________________________");
	System.out.println("1: Approve account");
	System.out.println("2: View account info");
	System.out.println("__________________________________");
}
public static void loginOptions()
{
	System.out.println("Please choose from the following options");
	System.out.println("___________________________________");
	System.out.println("1: Print History");
	System.out.println("2: Withdraw from an account");
	System.out.println("3: Deposit into account");
	System.out.println("4: Print account info ");
	System.out.println("5: Transfer funds");
	System.out.println("6: Exit to main menu");
	System.out.println("___________________________________");
}
}
