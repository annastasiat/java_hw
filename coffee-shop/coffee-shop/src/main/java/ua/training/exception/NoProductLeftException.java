package ua.training.exception;

/**
 * Такого продукта осталось меньше требуемого или вообде не осталось
 */
public class NoProductLeftException extends Exception {
    public NoProductLeftException() {
        super(ExceptionMessages.NO_PRODUCT_LEFT);
    }
}
