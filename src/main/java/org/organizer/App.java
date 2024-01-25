package org.organizer;

import org.organizer.actions.*;
import org.organizer.enums.CommandsEnums;
import org.organizer.exceptions.InvalidCommandExeption;

import java.util.ArrayList;
import java.util.Scanner;


public class App {

    private AddAction addAction = new AddAction();
    private ToDoList toDoList = ToDoList.getInstance();
    private EditAction editAction = new EditAction();
    private RemoveAction removeAction = new RemoveAction();
    private ListAction listAction = new ListAction();
    HelpAction helpAction = new HelpAction();


    public static void main(String[] args) {
        HelpAction helpAction1 = new HelpAction();
        App app = new App();
        app.appHeader();
        while (true) {
            String inputLine = app.getUserInput();
            if (inputLine.startsWith(String.valueOf(CommandsEnums.EXIT))) {
                System.exit(0);
            } else {
                try {
                    CommandsEnums.isCommandExistSByCommandName(inputLine.split(" ")[0]);
                    app.parseData(inputLine);
                } catch (InvalidCommandExeption e) {
                    System.out.println("This command does not exist. Here are all available commands you can use:");
                    helpAction1.printAvailableCommands();
                }

            }
        }
    }


    private void appHeader() {
        System.out.printf("%nOrganizer - is a console app where you can create and view your own ToDo List. %n %n");
        System.out.println("Here are available commands to use:");
        helpAction.printAvailableCommands();
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void parseData(String entryLine) throws InvalidCommandExeption {
        String commandInput = entryLine.split(" ")[0];
        switch (CommandsEnums.valueOf(commandInput)) {
            case CommandsEnums.ADD:
                addAction.addTask(entryLine);
                break;
            case CommandsEnums.EDIT:
                editAction.editList(entryLine);
                break;
            case CommandsEnums.REMOVE:
                removeAction.removeItem(entryLine);
                break;
            case CommandsEnums.LIST:
                System.out.println("Here is your ToDo list: ");
                listAction.printList(toDoList.getToDoList());
                break;
            case CommandsEnums.HELP:
                System.out.println("Here are available commands to use:");
                helpAction.printAvailableCommands();
                break;

            default:
                throw new InvalidCommandExeption(commandInput);
        }
    }


}



