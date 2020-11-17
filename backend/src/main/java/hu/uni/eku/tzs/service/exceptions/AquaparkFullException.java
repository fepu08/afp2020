package hu.uni.eku.tzs.service.exceptions;

public class AquaparkFullException extends Exception{
    public AquaparkFullException() {
    }

    public AquaparkFullException(String message) {
        super(message);
    }

    public AquaparkFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AquaparkFullException(Throwable cause) {
        super(cause);
    }

    public AquaparkFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
