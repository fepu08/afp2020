package hu.uni.eku.tzs.service.exceptions;

public class WatchNotFoundException extends Exception{
    public WatchNotFoundException() {
    }

    public WatchNotFoundException(String message) {
        super(message);
    }

    public WatchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchNotFoundException(Throwable cause) {
        super(cause);
    }

    public WatchNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
