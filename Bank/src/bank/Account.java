package bank;

public class Account extends Data{
public String accountNumber;
public String name;
public String lastName;
public String nameJoint;
public String lastNameJoint;
public boolean approved = false;
public double balance;
public String userN;
private String password;
public boolean active = false;



//constructor;
Account (String name,String lastName, String userN, String password, double balance)
{
	this.name = name;
	this.lastName=lastName;
	this.userN=userN;
	this.password=password;
	this.balance=balance;
	
	
	
}
Account (String name,String lastName, String nameJoint,String lastNameJoint, String userN, String password, double balance)
{
	
	this.name = name;
	this.lastName=lastName;
	this.nameJoint=nameJoint;
	this.lastNameJoint=lastNameJoint;
	this.userN=userN;
	this.password=password;
	this.balance=balance;
	
}








// Methods;

public String getPassword() {
	return this.password;
}
public void approve(String accountNumber)
{
	approved = true;
	this.accountNumber = accountNumber;

	
}
public void withdraw(double ammount)
{
	if(approved&&this.balance>0) {
	balance = balance - ammount;
	}
	else
	{
		System.out.println("Not enough funds, please try again");
	}
	return;
}
public void deposit(double ammount)
{
	if(approved) {
	balance = balance + ammount;
	}
	return;
}
}
