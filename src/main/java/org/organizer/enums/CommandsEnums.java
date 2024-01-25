package org.organizer.enums;

import org.organizer.exceptions.InvalidCommandExeption;

public enum CommandsEnums {
    ADD("ADD", "uses in order to add a task into your own To Do List."),
    EDIT("EDIT", "uses in order to edit any item in your own To Do List."),
    REMOVE("REMOVE", "uses in order to remove any task from your own To Do List"),
    LIST("LIST", "uses to see all existed tasks in your own To Do List"),
    EXIT("EXIT", "uses to finish working with Organizer."),
    HELP("HELP", "uses to see all available commands in the Organizer console app.");

    private String description;
    private String commandName;

    CommandsEnums(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }


    public String getCommandName() {
        return this.commandName;
    }

    public String getDescription() {
        return this.description;
    }

    public static boolean isCommandExistSByCommandName(String nameOfCommand) throws InvalidCommandExeption{
        for (CommandsEnums item : CommandsEnums.values()) {
            if (item.getCommandName().equals(nameOfCommand)) {
                return true;
            }
        }
        throw new InvalidCommandExeption(nameOfCommand);
    }


}
