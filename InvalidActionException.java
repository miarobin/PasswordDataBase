public class InvalidActionException extends Exception
{
	private String invalidComment;
	
	public InvalidActionException(String comment)
	{
		invalidComment = comment;
	}
	
	public String toString()
	{
		return invalidComment;
	}
}