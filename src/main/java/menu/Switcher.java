package menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Switcher {

    @Autowired
    private List<Command> commands;

    public Switcher() {
    }

    public void addComand(Command cmd) {
        this.commands.add(cmd);
    }

    public void execute(Integer number) {
        commands.get(number).execute();
    }

    public void printOptions() {

    }
}
