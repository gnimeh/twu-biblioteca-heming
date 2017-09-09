package com.twu.model;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    List<Option> options;

    public Menu(List<Option> options) {
        this.options = options;
    }

    public String getMenuStr() {
        final String[] menuStr = {""};
        options.forEach(option -> menuStr[0] += option.getTitle());
        return menuStr[0];
    }

    public Option getOptionByTitle(String input) {
        List<Option> matchOption = options.stream().filter(option1 -> option1.getTitle().equals(input))
                .collect(Collectors.toList());
        if (matchOption.size() <= 0) {
            return new Option("invalid");
        }
        return matchOption.get(0);
    }
}
