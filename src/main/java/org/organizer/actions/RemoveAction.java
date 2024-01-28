package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.exceptions.InvalidCommandException;

import java.util.Map;

public class RemoveAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void removeItem(Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (!parseCommandMap.get("index").equals(StringUtils.EMPTY) && (parseCommandMap.get("item") == null)) {
            int indexToRemove = Integer.parseInt(parseCommandMap.get("index")) - 1;
            if (indexToRemove < toDoList.getToDoList().size()) {
                String oldValue = toDoList.getToDoList().get(indexToRemove);
                toDoList.getToDoList().remove(indexToRemove);
                System.out.println(String.format("You've successfully removed the '%s' item from the ToDo List %n", oldValue));

            } else {
                System.out.println("Please, enter the command again with valid index.");
            }

        } else {
            throw new InvalidCommandException();

        }

    }
}
