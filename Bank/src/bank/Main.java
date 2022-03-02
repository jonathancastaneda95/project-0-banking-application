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
		System.out.println("Choose 1 for employee login, 2 to create account, 3 to login to account");
		String mainMenu = s.nextLine();
		switch(mainMenu)
		{
		case "1" : bankEmployeeI.runEmp(s);
			break;
		case "2" : userI ui = new userI();
					ui.run(s);
			break;
		case "3": AccountLogin al = new AccountLogin();
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
