package org.organizer.utils;

import org.organizer.ToDoList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileUtils {
    private static final String FILE_NAME = "toDoList.txt";
    private static final Path rootPath = Paths.get(System.getProperty("user.dir"));
    private static final Path resourcesPath = rootPath.resolve("src").resolve("main").resolve("resources");
    private static String getResourcesPath = resourcesPath.toString();
    private ToDoList toDoList = ToDoList.getInstance();


    public void readFile() {
        createIfNotExists(FILE_NAME);
        try (BufferedReader reader = Files.newBufferedReader(resourcesPath.resolve(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Arrays.stream(values)
                        .map(item -> item.trim().replaceAll("[\\[\\]]", ""))
                        .forEach(item -> toDoList.getToDoList().add(item));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean writeToFile(ArrayList<String> toDoList) {
        File file = createIfNotExists(FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.valueOf(toDoList));
            System.out.println("Writing data into the toDoList file...");
            return true;
        } catch (IOException e) {
            System.out.println("Some issue happened while trying to write data into the file.");
            return false;
        }
    }

    private File createIfNotExists(String fileName) {
        File file = new File(getResourcesPath, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Some issue happened while trying to check whether the file exists.");
            }
        }
        return file;
    }

}
