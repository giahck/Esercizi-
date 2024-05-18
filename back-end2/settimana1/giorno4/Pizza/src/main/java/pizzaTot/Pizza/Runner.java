package pizzaTot.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pizzaTot.Pizza.Enum.EnumGradoAl;
import pizzaTot.Pizza.bean.Bevanda;
import pizzaTot.Pizza.bean.Ingrediente;
@Component
public class Runner implements CommandLineRunner {




    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PizzaApplication.class);
        /*System.out.println( ctx.getBean(Runner.class));*/

    }
}
