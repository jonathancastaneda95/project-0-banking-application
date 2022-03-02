package bank;

import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	Account a = new Account("Jonathan","Castaneda", "jcstn", "password", 150);
	Data.accounts.add(a);
	
	while(true)
	{
		System.out.println("Choose 1 for admin login,2 for employee login 3 to create account, 4 to login to account");
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
	
	//userI ui = new userI();
	//ui.run(s);
	
//	bankEmployeeI.runEmp(s);
//	
}
}
