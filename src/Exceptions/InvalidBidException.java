package Exceptions;

public class InvalidBidException extends RuntimeException{
    public InvalidBidException (String msg) {
        super(msg);
    }
}
