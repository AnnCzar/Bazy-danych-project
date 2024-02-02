package org.example.demo5;

public class InvalidUsernameException extends RuntimeException {
    /**
     * Exception thrown when attempting to use an invalid username.
     * This exception is a subclass of RuntimeException.
     */
    public InvalidUsernameException(String message) {
        /**
         * Constructs a new InvalidUsernameException with the specified detail message.
         *
         * @param message the detail message (which is saved for later retrieval by the getMessage() method)
         */
        super(message);
    }
}