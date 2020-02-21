package ua.training.exception;

/**
 * Такого продукта вообще нет в БД
 */
public class NoProductExistException extends Exception {
    public NoProductExistException() {
        super(ExceptionMessages.NO_RECORD_IN_DB);
    }
}