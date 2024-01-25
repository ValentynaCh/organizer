package org.organizer.actions;

import org.organizer.ToDoList;
import org.organizer.enums.CommandsEnums;

public class HelpAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void printAvailableCommands(){
        for (CommandsEnums item: CommandsEnums.values()){
            System.out.println(item.getCommandName() + " --> " + item.getDescription());
        }
        System.out.printf("%nEnter your command or EXIT to finish using the Organizer console app: %n");
    }
}
