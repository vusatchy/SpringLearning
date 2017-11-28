package menu.commands;

import menu.Command;
import org.springframework.beans.factory.annotation.Autowired;
import services.UserService;

import java.util.Scanner;

public class GetUserByNameCommand implements Command {
    @Autowired
    UserService userService;

    public GetUserByNameCommand(){

    }

    @Override
    public void execute() {
        System.out.print("Input name:");
        Scanner scanner = new Scanner(System.in);
        userService.getByFirstName(scanner.next()).forEach(System.out::println);
    }
}
