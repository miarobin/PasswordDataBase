public class InvalidPasswordException extends Exception
{
	private String invalidComment;
	
	public InvalidPasswordException(String comment)
	{
		invalidComment = comment;
	}
	
	public String toString()
	{
		return "The inputted password is " + invalidComment;
	}
}