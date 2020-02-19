package ua.training.exception;

public class NoProductLeftException extends Exception {
    public NoProductLeftException(){
        super(ExceptionMessages.NO_PRODUCT_LEFT);
    }
}
