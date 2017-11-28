package configurations;


import menu.*;
import menu.commands.GetAllEventsBetweenCommand;
import menu.commands.GetAllEventsCommand;
import menu.commands.GetAllUsersCommand;
import menu.commands.GetUserByNameCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.*;
import services.App;
import services.strategy.BirthdayDiscountStrategy;
import services.strategy.DiscountStrategy;
import services.strategy.TenTicketsDiscountStrategy;

@Configuration
public class AppConfigs {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public App app() {
        return new App();
    }

    @Bean
    public EventService eventService() {
        return new EventService();
    }

    @Bean
    public DiscountService discountService() {
        return new DiscountService();
    }

    @Bean
    public AuditoriumService auditoriumService() {
        return new AuditoriumService();
    }

    @Bean
    public DiscountStrategy birthdayDiscountStrategy() {
        return new BirthdayDiscountStrategy();
    }

    @Bean
    public DiscountStrategy tenTicketsDiscountStrategy() {
        return new TenTicketsDiscountStrategy();
    }

    @Bean
    public ConsoleMenu consoleMenu(){ return  new ConsoleMenu();}

    @Bean
    public Switcher switcher(){ return  new Switcher();}

    @Bean
    public Command getAllUsersCommand(){return new GetAllUsersCommand();}

    @Bean
    public Command getAllUserByNameCommand(){return  new GetUserByNameCommand();}

    @Bean
    public Command getAllEventsCommand() {return  new GetAllEventsCommand();}

    @Bean
    public Command getAllEventsBetweenCommand() {return  new GetAllEventsBetweenCommand();}
}
