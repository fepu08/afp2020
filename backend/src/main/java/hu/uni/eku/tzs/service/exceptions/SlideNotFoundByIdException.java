package hu.uni.eku.tzs.service.exceptions;

public class SlideNotFoundByIdException extends Exception{
    public SlideNotFoundByIdException() {
    }

    public SlideNotFoundByIdException(String message) {
        super(message);
    }

    public SlideNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlideNotFoundByIdException(Throwable cause) {
        super(cause);
    }

    public SlideNotFoundByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
