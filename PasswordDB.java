import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class PasswordDB
{
	private ArrayList<User> users;
	
	public PasswordDB()
	{
		users = new ArrayList<User>();
	}
	
	public static void main(String[] args)
	{
		PasswordDB dataBase = new PasswordDB();
		
		System.out.println("Welcome to the java Password Database.");
		
		boolean action = true;
		while(action == true)
		{
			try
			{
				action = dataBase.action();
			}
			catch (InvalidActionException exception)
			{
				System.out.println(exception.toString());
				System.out.println("Please try again.");
			}
		}
		
	}
	
	public boolean action() throws InvalidActionException
	{
		System.out.println("Please input the number corresponding to what you want to see");
		
		System.out.println("[1] - Add user");
		System.out.println("[2] - Search database");
		System.out.println("[3] - Quit");
		Scanner input = new Scanner(System.in);
		
		
		int actionNo = input.nextInt();
		
		if(actionNo == 1)
		{
			System.out.println("");
			inputNewUserDetails();
			System.out.println("");
			return true;
		}
		else if(actionNo == 2)
		{
			System.out.println("");
			searchDataBase();
			System.out.println("");
			return true;
		}
		else if(actionNo == 3)
		{
			System.out.println("Thank you!");
			return false;
		}
		else
		{
			
			throw new InvalidActionException("The number inputted was not valid.");
		}
		
	}
	
	public void searchDataBase()
	{
		System.out.println("Input a user name.");
		Scanner input = new Scanner(System.in);
		
		String userName = input.nextLine();
		userName.trim();
		
		int count = 0;
		for(User user : users)
		{
			if(userName.equals(user.getUserName()))
			{
				System.out.println(user.toString());
				count ++;
			}
		}
		if(count == 0)
		{
			System.out.println("Nobody with that username exists in the database.");
		}
	}
	
	public void inputNewUserDetails()
	{
		Scanner input = new Scanner(System.in);

		try
		{
			//TRIMMING!!
			System.out.println("Name: ");
			String name = input.nextLine();
			name.trim();
			System.out.println("UserName: ");
			String userName = input.nextLine();
			userName.trim();
			System.out.println("Email Address: ");
			String emailAddress = input.nextLine();
			emailAddress.trim();
			System.out.println("Password: ");
			String password = input.nextLine();
			password.trim();
			createUser(name, userName, emailAddress, password);
			System.out.println("User added to database");
		}
		
//catch(IOException exception)
		//{
			//System.out.println(exception.toString());
			//System.out.println("Please enter details again: ");
			
			//inputNewUserDetails();
		//}
		catch (InvalidUserNameException userNameException)
		{
			System.out.println(userNameException.toString());
			System.out.println("Please enter details again: ");
			inputNewUserDetails();
		}
		catch (InvalidPasswordException passwordException)
		{
			System.out.println(passwordException.toString());
			System.out.println("Please enter details again: ");
			inputNewUserDetails();
		}
	}
	
	
	
	public void createUser(String name, String userName, String emailAddress, String password) throws InvalidUserNameException, InvalidPasswordException
	{
		if(password.length() < 8)
			throw new InvalidPasswordException("Password is less than 8 characters long");
		
		for(User eachUser: users)
		{
			if(userName.equals(eachUser.getUserName()))
			{
				throw new InvalidUserNameException("User name is already in use.");
			}
		}
		User user = new User(name, userName, emailAddress, password);
		users.add(user);
	}
}