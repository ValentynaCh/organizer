package org.organizer.actions;

import org.organizer.ToDoList;

public class RemoveAction {
    private ToDoList toDoList = ToDoList.getInstance();

    public void removeItem(String entryLine){
        String[] removeInList = entryLine.split(" ", 2);
        try{
            int indexToRemove = Integer.parseInt(removeInList[1]);
            String oldValue = toDoList.getToDoList().get(indexToRemove);
            toDoList.getToDoList().remove(indexToRemove);
            System.out.printf("You've successfully removed the '%s' item from the ToDo List %n", oldValue);
        }
        catch (NumberFormatException e){
            System.out.println("ERROR: Please, enter this command again with correct format: REMOVE index");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("ERROR: Please, enter this command again with existed index");
        }
    }
}
