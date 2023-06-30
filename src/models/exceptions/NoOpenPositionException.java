package models.exceptions;

public class NoOpenPositionException extends Exception {
    public NoOpenPositionException(String message) {
        super(message);
    }
}

