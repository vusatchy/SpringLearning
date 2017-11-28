package menu.commands;

import menu.Command;
import org.springframework.beans.factory.annotation.Autowired;
import services.EventService;

import java.time.LocalDate;
import java.util.Scanner;

public class GetAllEventsBetweenCommand implements Command {

    @Autowired
    private EventService eventService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input from year:");
        int fYear = scanner.nextInt();
        System.out.print("Input from month:");
        int fMonth = scanner.nextInt();
        System.out.print("Input from day:");
        int fDay = scanner.nextInt();
        System.out.print("Input to year:");
        int tYear = scanner.nextInt();
        System.out.print("Input to month:");
        int tMonth = scanner.nextInt();
        System.out.print("Input to day:");
        int tDay = scanner.nextInt();

        eventService.getForDateRange(LocalDate.of(fYear,fMonth,fDay),LocalDate.of(tYear,tMonth,tDay)).forEach(System.out::println);
    }
}
