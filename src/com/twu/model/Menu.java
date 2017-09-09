package com.twu.model;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    List<String> options;

    public Menu(List<String> options) {
        this.options = options;
    }

    public String getMenuStr() {
        final String[] menuStr = {""};
        menuStr[0] += "Menu:\n--------------------\n";
        options.forEach(option -> menuStr[0] += option + "\n");
        return menuStr[0];
    }

    public String getOptionByTitle(String input) {
        List<String> matchOption = options.stream().filter(option1 -> option1.equals(input))
                .collect(Collectors.toList());
        if (matchOption.size() <= 0) {
            return "invalid";
        }
        return matchOption.get(0);
    }
}
