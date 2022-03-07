package bank;

import java.util.Scanner;

public class AccountLogin extends Data {
	Scanner loginScan = new Scanner(System.in);
	String tempUN;
	String tempPass;
	
	
	
	public void login()
	{
		System.out.println("****************************");
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
				System.out.println("___________________________________");
				System.out.println("1: Print History");
				System.out.println("2: Withdraw from an account");
				System.out.println("3: Deposit into account");
				System.out.println("4: Print account info ");
				System.out.println("5: Transfer funds");
				System.out.println("___________________________________");


				
				String option = loginScan.nextLine();
				
				switch(option)
				{
				case "1": log.printHistory();
				return;
				case "2":
					System.out.println("Please enter withdraw ammount");
					double tempW= loginScan.nextDouble();
					if(tempW>0) {
					log.withdraw(tempW);
					Data.serialize();

					return;
					}else {
						while(tempW<0) {
							System.out.println("Ammount can not be less than zero");
							System.out.println("Please enter withdraw ammount");
							double tempBalance = log.balance-tempW;
							tempW= loginScan.nextDouble();
							if(tempW>0) {
							log.withdraw(tempW);
							log.history.add("Withraw :"+ String.valueOf(tempW)+" Balance: "+ String.valueOf(tempBalance));
							Data.serialize();
							return;
							}
						}
					}
				case "3":  
					System.out.println("Please enter deposit ammount");
					double tempD= loginScan.nextDouble();
					if(tempD>0) {
					log.deposit(tempD);
					Data.serialize();

					return;
					}else {
						while(tempD<0) {
							System.out.println("Ammount can not be less than zero");
							System.out.println("Please enter deposit ammount");
							tempD= loginScan.nextDouble();
							double tempBalance= log.balance+tempD;
							if(tempD>0) {
							log.deposit(tempD);
							log.history.add("Deposit :"+ String.valueOf(tempD)+" Balance: "+ String.valueOf(tempBalance));
							//Data.serialize(log);

							return;
							}
						}
					}
				case "4":
					Menu.listAccountInfo(log);

						return;
				case "5":
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
							log.history.add("Transfer out of :"+ String.valueOf(transferAmount)+" Balance: "+ String.valueOf(log.balance));
							tto.balance = tto.balance+transferAmount;
							tto.history.add("Transfer in of :"+ String.valueOf(transferAmount)+" Balance: "+ String.valueOf(tto.balance));
							System.out.println("The new balance for " + tto.name +" " + tto.lastName + "is: " + tto.balance);
							System.out.println("The new balance for " +log.name +": " + log.balance)  ;
							Data.serialize();

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
