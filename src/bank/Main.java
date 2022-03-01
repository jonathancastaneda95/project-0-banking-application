package bank;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Account a = new Account("Jonathan","Castaneda", "jcstn", "password", 150);
	System.out.println(a.balance);
	
	Scanner s = new Scanner(System.in);
	//userI ui = new userI();
	//ui.run(s);
	bankEmployeeI bi= new bankEmployeeI();
	bi.runEmp(s);
	
}
}
