package org.organizer.actions;

import org.organizer.ToDoList;

public class AddAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void addTask(String entryLine){
        String addToList = entryLine.split(" ", 2)[1];
        toDoList.getToDoList().add(addToList);
        System.out.printf("Your new task \"%s\" has been added to the ToDo List %n", addToList);

    }
}
