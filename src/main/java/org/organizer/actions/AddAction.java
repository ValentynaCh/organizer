package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.exceptions.InvalidCommandException;


import java.util.Map;

public class AddAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void addTask(Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (parseCommandMap.get("index").equals(StringUtils.EMPTY) && !parseCommandMap.get("item").equals(StringUtils.EMPTY)) {
            String itemValue = parseCommandMap.get("item");
            toDoList.getToDoList().add(itemValue);
            System.out.println(String.format("You've just added a new value '%s' to your ToDo List.", itemValue));
        } else {
            throw new InvalidCommandException();
        }
    }
}
