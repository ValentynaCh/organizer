package org.organizer.exceptions;

public class InvalidCommandExeption extends Exception{
    public InvalidCommandExeption(String invalidCommand){
        super("Entered command is invalid {%s}.".formatted(invalidCommand));
    }
}
