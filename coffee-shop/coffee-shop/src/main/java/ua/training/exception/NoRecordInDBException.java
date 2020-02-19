package ua.training.exception;

public class NoRecordInDBException extends Exception {
    public NoRecordInDBException(){
        super(ExceptionMessages.NO_RECORD_IN_DB);
    }
}