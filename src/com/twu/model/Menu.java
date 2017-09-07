package com.twu.model;

import java.util.List;
import java.util.Objects;

public class Menu {
    List<Option> options;

    public Menu(List<Option> options) {
        this.options = options;
    }

    public String getMenuStr() {
        String menuStr = "";
        for (Option option :
                options) {
            menuStr += option.getTitle();
        }
        return menuStr;
    }

    public Boolean isInvalidOption(String title){
        return Objects.isNull(options.stream().filter(option -> option.getTitle().equals(title)));
    }
}
