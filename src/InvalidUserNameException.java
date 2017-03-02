public class InvalidUserNameException extends Exception
{
	private String invalidComment;
	
	public InvalidUserNameException(String comment)
	{
		invalidComment = comment;
	}
	
	public String toString()
	{
		return invalidComment;
	}
}