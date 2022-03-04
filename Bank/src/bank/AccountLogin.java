package bank;

import java.util.Scanner;

public class AccountLogin extends Data {
	Scanner loginScan = new Scanner(System.in);
	String tempUN;
	String tempPass;
	
	
	
	public void login()
	{
		System.out.println("Please enter your username");
		tempUN= loginScan.nextLine();
		System.out.println("Please enter your password");
		tempPass=loginScan.nextLine();
		for(Account log: accounts)
		{
			if (tempUN.equals(log.userN)&&tempPass.equals(log.getPassword()))
			{
			if(log.approved) {
				System.out.println("Please choose from the following options");
				System.out.println("1: Withdraw from an account--2: Deposit into an account");
				System.out.println("3: Print account info 4: Transfer funds ");
				
				String option = loginScan.nextLine();
				
				switch(option)
				{
				case "1":
					System.out.println("Please enter withdraw ammount");
					double tempW= loginScan.nextDouble();
					if(tempW>0) {
					log.withdraw(tempW);
					return;
					}else {
						while(tempW<0) {
							System.out.println("Ammount can not be less than zero");
							System.out.println("Please enter withdraw ammount");
							tempW= loginScan.nextDouble();
							if(tempW>0) {
							log.withdraw(tempW);
							return;
							}
						}
					}
				case "2":  
					System.out.println("Please enter deposit ammount");
					double tempD= loginScan.nextDouble();
					if(tempD>0) {
					log.deposit(tempD);
					return;
					}else {
						while(tempD<0) {
							System.out.println("Ammount can not be less than zero");
							System.out.println("Please enter deposit ammount");
							tempD= loginScan.nextDouble();
							if(tempD>0) {
							log.deposit(tempD);
							return;
							}
						}
					}
				case "3": System.out.println(log.name);
				System.out.println("Name: " + log.name);
				System.out.println("Last name: " + log.lastName);
				System.out.println("Name of Joint holder: " + log.nameJoint);
				System.out.println("Last Name of Joint holder: "+log.lastNameJoint);
				System.out.println("Account number: "+log.accountNumber);
				System.out.println("Account balance: "+log.balance);
				System.out.println("Account Approved?: "+log.approved);
				System.out.println("Account username: "+log.userN);
					return;
				case "4":
					System.out.println("Please enter the account number you would like to transfer to");
					String tempANto = loginScan.nextLine();
					System.out.println("Please enter amount to transfer");
					double transferAmount= Double.parseDouble(loginScan.nextLine());
				if(transferAmount>0) {
					double tempBalance = log.balance-transferAmount;
					if(tempBalance >0) {
					for(Account tto: accounts)
					{
						if (tempANto.equals(tto.accountNumber)&& tto.approved)
						{
							log.balance=tempBalance;
							tto.balance = tto.balance+transferAmount;
							System.out.println("The new balance for " + tto.name +" " + tto.lastName + "is: " + tto.balance);
							System.out.println("The new balance for " +log.name +": " + log.balance)  ;
							return;
						}
					}
					System.out.println("Account not found please try again");
					return;
					}
					System.out.println("Non suficient funds");
					return;
				}else {
					System.out.println("Ammount cannot be zero");
					login();
				}
				default: System.out.println("entry not valid try again"); login();
				}
			}else
			{
				System.out.println("Account not approved, please wait for bank to approve");
				return;
			}
				
			}
		}
		System.out.println("Account not found");
		return;
	}
	
	

}
