package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.exceptions.InvalidCommandException;

import java.util.Map;

public class EditAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void editList(Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (!parseCommandMap.get("index").equals(StringUtils.EMPTY) && !parseCommandMap.get("item").equals(StringUtils.EMPTY)) {
            int indexValue = Integer.parseInt(parseCommandMap.get("index")) - 1;
            if (indexValue < toDoList.getToDoList().size()) {
                String oldValue = toDoList.getToDoList().get(indexValue);
                String newValue = parseCommandMap.get("item");
                toDoList.getToDoList().set(indexValue, newValue);
                System.out.println(String.format("You've just edited the '%s' to a new '%s' value.", oldValue, newValue));
            } else {
                System.out.println("Please, enter the command again with valid index.");
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
