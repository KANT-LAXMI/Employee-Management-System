package custom_Exceptions;

@SuppressWarnings("serial")
public class EmployeeHandlingException extends Exception{
	public EmployeeHandlingException(String errMessage) {
		super(errMessage);
	}

}
