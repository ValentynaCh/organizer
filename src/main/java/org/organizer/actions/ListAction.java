package org.organizer.actions;

import org.organizer.ToDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void printList(ArrayList<String> toDoList) {
        Map<Integer, String> toDoListWithIndex = new HashMap<>();
        for (int i = 0; i < toDoList.size(); i++) {
            toDoListWithIndex.put(i, toDoList.get(i));
            System.out.println(i + " - " + toDoList.get(i));

        }

    }
}


