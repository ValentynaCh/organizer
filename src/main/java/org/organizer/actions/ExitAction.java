package org.organizer.actions;

import org.apache.commons.lang3.StringUtils;
import org.organizer.exceptions.InvalidCommandException;

import java.util.Map;

public class ExitAction {

    public void exitApp(Map<String, String> parseCommandMap) throws InvalidCommandException {
        if (parseCommandMap.get("index").equals(StringUtils.EMPTY) && (parseCommandMap.get("item").equals(StringUtils.EMPTY))) {
            System.out.println("Exiting from the app...");
            System.exit(0);

        } else {
            throw new InvalidCommandException();
        }

    }
}
