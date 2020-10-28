package hu.uni.eku.tzs.service.exceptions;

public class GuestNotFoundByIDException extends Throwable {

    public GuestNotFoundByIDException() {}

    public GuestNotFoundByIDException(String message) {
        super(message);
    }

    public GuestNotFoundByIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestNotFoundByIDException(Throwable cause) {
        super(cause);
    }

    public GuestNotFoundByIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
