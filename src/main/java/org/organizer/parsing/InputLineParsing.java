package org.organizer.parsing;

import org.apache.commons.lang3.StringUtils;
import org.organizer.enums.CommandsEnums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputLineParsing {

    private Pattern pattern = Pattern.compile("\\w+\\-(\\d*)?(\\-)?(.+)?");


    public Map<String, String> getParseCommandMap(String inputLine) {
        Map<String, String> parseCommandMap = new HashMap<>();
        parseCommandMap.put("command", getCommand(inputLine));
        parseCommandMap.put("index", getCommandIndex(inputLine));
        parseCommandMap.put("item", getCommandItem(inputLine));
        return parseCommandMap;
    }


    public String getCommand(String inputLine) {
        return Arrays.stream(CommandsEnums.values())
                .filter(command -> inputLine.startsWith(command.getCommandName()))
                .findFirst()
                .map(CommandsEnums::getCommandName)
                .orElse(StringUtils.EMPTY);
    }

    public String getCommandIndex(String inputLine) {
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return StringUtils.EMPTY;
        }
    }

    public String getCommandItem(String inputLine) {
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.find()) {
            return matcher.group(3);
        } else {
            return StringUtils.EMPTY;
        }
    }

}


