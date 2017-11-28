import configurations.AppConfigs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.App;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigs.class);
        App app = context.getAutowireCapableBeanFactory().getBean(App.class);
        app.run();
    }
}
