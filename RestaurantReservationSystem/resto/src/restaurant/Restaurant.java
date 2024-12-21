package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void showMenu() {
        System.out.println("Menu for " + name + ":");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}
