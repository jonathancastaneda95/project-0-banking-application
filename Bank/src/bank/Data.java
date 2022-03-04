package bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Data {
static Set<Account> accounts = new HashSet<Account>();
static ArrayList<Account> accountsNeedApproval= new ArrayList<>();

public static void serialize() {
	try
	{
		FileOutputStream fileOut = new FileOutputStream("./src/accountDetails.ser");
		ObjectOutputStream  out = new ObjectOutputStream(fileOut);
		out.writeObject(accounts);
		out.close();
		fileOut.close();
		
	}
	catch(IOException ex)
	{
		System.out.println("Exception");
		ex.printStackTrace();
	}
	
}
public static void deserialize()
{
	
	try
	{
		FileInputStream fileIn = new FileInputStream("./src/accountDetails.ser");
		ObjectInputStream  in = new ObjectInputStream(fileIn);
		accounts=(HashSet) in.readObject();
		in.close();
		fileIn.close();
		
		
	}
	catch(IOException ex)
	{
		System.out.println("Exception");
		ex.printStackTrace();
	}
	catch(ClassNotFoundException cnf)
	{
		System.out.println("Class not found");
	}
}
}
