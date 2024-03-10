package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.ToDoList;
import org.organizer.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class ListAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void printList(ArrayList<String> toDoList, Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (parseCommandMap.get("index").equals(StringUtils.EMPTY) && (parseCommandMap.get("item").equals(StringUtils.EMPTY))) {
            Map<Integer, String> toDoListWithIndex = new HashMap<>();

            IntStream.range(0, toDoList.size())
                    .forEach(i -> {
                        toDoListWithIndex.put(i, toDoList.get(i));
                        System.out.println(i + 1 + " - " + toDoList.get(i));
                    });
        } else {
            throw new InvalidCommandException();
        }

    }


}


