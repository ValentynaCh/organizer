package org.organizer;

import java.util.ArrayList;

public class ToDoList {
    private static ToDoList instance = null;
    private ArrayList<String> toDoList;

    private ToDoList() {
        toDoList = new ArrayList<>();
    }

    public static ToDoList getInstance() {
        if (instance == null) {
            instance = new ToDoList();
        }
        return instance;
    }

    public ArrayList<String> getToDoList() {
        return toDoList;
    }
}
