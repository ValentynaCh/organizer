package org.organizer.enums;


public enum CommandsEnums {
    ADD("ADD", "uses in order to add a task into your own To Do List. Valid format: ADD-item value"),
    EDIT("EDIT", "uses in order to edit any item in your own To Do List. Valid format: EDIT-digit-item value"),
    REMOVE("REMOVE", "uses in order to remove any task from your own To Do List. Valid format: REMOVE-digit"),
    LIST("LIST", "uses to see all existed tasks in your own To Do List. Valid format: LIST"),
    EXIT("EXIT", "uses to finish working with Organizer. Valid format: EXIT"),
    HELP("HELP", "uses to see all available commands in the Organizer console app. Valid format: HELP");
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


}
