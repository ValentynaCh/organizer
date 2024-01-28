package org.organizer.exceptions;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Entered command is invalid. This problem may be related with wrong index or wrong data format.");
    }
}
