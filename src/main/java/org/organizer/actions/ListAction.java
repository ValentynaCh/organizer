package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void printList(ArrayList<String> toDoList, Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (parseCommandMap.get("index").equals(StringUtils.EMPTY) && (parseCommandMap.get("item").equals(StringUtils.EMPTY))) {
            Map<Integer, String> toDoListWithIndex = new HashMap<>();
            for (int i = 0; i < toDoList.size(); i++) {
                toDoListWithIndex.put(i, toDoList.get(i));
                System.out.println(i + 1 + " - " + toDoList.get(i));
            }
        } else {
            throw new InvalidCommandException();
        }

    }
}


