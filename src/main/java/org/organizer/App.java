package org.organizer;

import org.organizer.actions.*;
import org.organizer.enums.CommandsEnums;
import org.organizer.exceptions.InvalidCommandException;
import org.organizer.parsing.InputLineParsing;
import org.organizer.utils.FileUtils;

import java.util.Scanner;


public class App {

    private AddAction addAction = new AddAction();
    private ToDoList toDoList = ToDoList.getInstance();
    private EditAction editAction = new EditAction();
    private RemoveAction removeAction = new RemoveAction();
    private ListAction listAction = new ListAction();
    private HelpAction helpAction = new HelpAction();
    private InputLineParsing inputLineParsing = new InputLineParsing();
    private ExitAction exitAction = new ExitAction();
    private FileUtils fileUtils = new FileUtils();


    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();

        InputLineParsing inputLineParsing = new InputLineParsing();
        App app = new App();
        app.appHeader();
        String inputLine;
        fileUtils.readFile();

        while (true) {
            try {
                inputLine = app.getUserInput();
                app.parseData(inputLine);
                if (inputLineParsing.getCommand(inputLine).equals(CommandsEnums.EXIT.getCommandName())) {
                    System.exit(0);
                }
            } catch (InvalidCommandException invalidCommandException) {
                System.out.println("Your command you've just entered is not valid. Please enter it again with valid format. To see all available options with theirs formats use the HELP command: ");
            }

        }
    }

    private void appHeader() {
        System.out.printf("%nOrganizer - is a console app where you can create and view your own ToDo List. %n %n");
        System.out.println("Here are available commands to use:");
        helpAction.printAvailableCommands();
    }

    private String getUserInput() {
        CommandsEnums.EXIT.getCommandName();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void parseData(String entryLine) throws InvalidCommandException {
        String commandName = inputLineParsing.getCommand(entryLine);
        switch (CommandsEnums.valueOf(commandName)) {
            case ADD:
                addAction.addTask(inputLineParsing.getParseCommandMap(entryLine));
                break;
            case EDIT:
                editAction.editList(inputLineParsing.getParseCommandMap(entryLine));
                break;
            case REMOVE:
                removeAction.removeItem(inputLineParsing.getParseCommandMap(entryLine));
                break;
            case LIST:
                if (toDoList.getToDoList().isEmpty()) {
                    System.out.println("Your ToDo List is empty.");
                } else {
                    System.out.println("Here is your ToDo list: ");
                    listAction.printList(toDoList.getToDoList(), inputLineParsing.getParseCommandMap(entryLine));
                }
                break;
            case HELP:
                helpAction.printHelp(inputLineParsing.getParseCommandMap(entryLine));
                break;
            case EXIT:
                fileUtils.writeToFile(toDoList.getToDoList());
                exitAction.exitApp(inputLineParsing.getParseCommandMap(entryLine));

            default:
                throw new InvalidCommandException();
        }
    }


}



