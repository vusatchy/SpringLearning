package menu;

import org.springframework.beans.factory.annotation.Autowired;
import services.UserService;

public class GetAllUsersCommand implements Command {

    @Autowired
    private UserService service;

    public GetAllUsersCommand() {

    }

    @Override
    public void execute() {
        System.out.println(service.getAll().size());
        service.getAll().stream().forEach(System.out::println);
    }
}
