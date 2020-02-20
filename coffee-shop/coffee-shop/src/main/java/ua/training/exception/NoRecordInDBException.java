package ua.training.exception;

/**
 * Такого продукта вообще нет в БД
 */
public class NoRecordInDBException extends Exception {
    public NoRecordInDBException() {
        super(ExceptionMessages.NO_RECORD_IN_DB);
    }
}