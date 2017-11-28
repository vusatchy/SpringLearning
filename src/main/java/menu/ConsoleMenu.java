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
       // switcher.addComand(new GetAllUsersCommand());
        options.add("0.Print all users");
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
