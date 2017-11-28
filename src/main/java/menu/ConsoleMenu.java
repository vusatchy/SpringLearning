package menu;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMenu {

    @Autowired
    private Switcher switcher;

    private List<String> options = new ArrayList<String>();

    public ConsoleMenu() {
       switcher = new Switcher();
       init();

    }

    private void init() {
       // switcher.addComand(new GetUserByNameCommand());
        options.add("0.Print all users");
        options.add("1.Get user by name command");
        options.add("2.Get all events");
        options.add("3.Get all events between");
        options.add("4.Get all events next to");
    }

    public void makeChoice(Integer number) {
        switcher.execute(number);
    }

    public void printOptions() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
    }

    public int getSize() {
        return options.size();
    }

}
