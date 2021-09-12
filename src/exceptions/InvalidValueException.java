package exceptions;

public class InvalidValueException extends RuntimeException
{
    public InvalidValueException()
    {
        super("Invalid value!\n");
    }
}
