package bank;


import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	//Data.deserialize();
	Scanner s = new Scanner(System.in);
	Account a = new Account("Jonathan", "Castaneda", "jcastaneda", "password", 500, true, "123456");
	Data.accounts.add(a);
	Account b = new Account("Jamie", "Mullins", "jmullins", "password", 200, true, "654321");
	Data.accounts.add(b);
	Data.serialize();
	
	try {
	while(true)
	{
		System.out.println("Please choose from the following options");
		System.out.println("__________________________");
		System.out.println("(1) Admin Login ");
		System.out.println("(2) Employee Login ");
		System.out.println("(3) Create Account");
		System.out.println("(4) Login to Account");
		System.out.println("__________________________");
		String mainMenu = s.nextLine();
		switch(mainMenu)
		{
		case "1" : 
			BankAdmin.runEmp(s);
			break;
		case "2": BankEmployee be = new BankEmployee()	;
					be.runEmp(s);
			break;
		case "3" : userI ui = new userI();
					ui.run(s);
			break;
		case "4": AccountLogin al = new AccountLogin();
				al.login() ;
			break;
		default: System.out.println("Entry not valid please try again");
				
		
		}
		
	}	
	} catch(Exception e) {
		System.out.println("System error"+ e.getMessage());
		
	}
	
	//userI ui = new userI();
	//ui.run(s);
	
//	bankEmployeeI.runEmp(s);
//	
}
}
