import java.io.*;
public class User
{
	private String name;
	private String userName;
	private String emailAddress;
	private String password;
	
	public User(String name, String userName, String emailAddress, String password)
	{
		this.name = name;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public String getName()
	{
		return name;
	}
	public String getUserName()
	{
		return userName;
	}
	public void changeUserName(String newUserName)
	{
		userName = newUserName;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public String getPassword()
	{
		return password;
	}
	public void changePassword(String newPassword) throws InvalidPasswordException
	{
		if(newPassword.length() < 8)
			throw new InvalidPasswordException("Password is less than 8 characters long");
		else
			password = newPassword;

	}
	
	public String toString()
	{
		return "Name: " + name + " User Name: " + userName + " Email Address: " + emailAddress + " Password: " + password;
	}
}