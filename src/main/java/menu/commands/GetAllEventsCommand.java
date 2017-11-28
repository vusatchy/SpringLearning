package menu.commands;

import menu.Command;
import org.springframework.beans.factory.annotation.Autowired;
import services.EventService;

public class GetAllEventsCommand implements Command {

    @Autowired
    private EventService eventService;

    @Override
    public void execute() {
        eventService.getAll().forEach(System.out::println);
    }
}
