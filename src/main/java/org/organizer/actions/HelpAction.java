package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.enums.CommandsEnums;
import org.organizer.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.Map;

public class HelpAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void printHelp(Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (parseCommandMap.get("index").equals(StringUtils.EMPTY) && (parseCommandMap.get("item").equals(StringUtils.EMPTY))) {
            printAvailableCommands();
        } else {
            throw new InvalidCommandException();
        }

    }

    public void printAvailableCommands() {


        Arrays.stream(CommandsEnums.values())
                .forEach(command -> System.out.println(command.getCommandName() + " --> " + command.getDescription()));

        System.out.printf("%nEnter any command from available and press Enter to start working with Organizer console app: %n");
    }
}
