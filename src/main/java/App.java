package services;

import configurations.AppConfigs;
import menu.ConsoleMenu;
import models.Event;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


@Service
public class App {

    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private DiscountService discountService;

    @Autowired
    ConsoleMenu consoleMenu;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            consoleMenu.printOptions();
            System.out.print("Choise:");
            int choise = scanner.nextInt();
            if (choise < consoleMenu.getSize()) consoleMenu.makeChoice(choise);
        }
    }

}
