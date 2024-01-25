package org.organizer.actions;

import org.organizer.ToDoList;

public class EditAction {
    private ToDoList toDoList = ToDoList.getInstance();
    public void editList(String entryLine){
        String[] editInList = entryLine.split(" ", 3);
        try{
            int indexToEdit = Integer.parseInt(editInList[1]);
            String newValue = editInList[2];
            String oldValue = toDoList.getToDoList().get(indexToEdit);
            toDoList.getToDoList().set(indexToEdit, newValue);
            System.out.printf("You've successfully edited the old task '%s' to the new - '%s' %n", oldValue, newValue);
        }
        catch (NumberFormatException e){
            System.out.println("ERROR: Please, enter this command again with correct format: EDIT index value." );
            e.printStackTrace();

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Please, enter this command again with existed index.");
            e.printStackTrace();
        }
    }
}
