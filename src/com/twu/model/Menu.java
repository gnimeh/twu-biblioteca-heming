package com.twu.model;

import java.util.List;

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
}
