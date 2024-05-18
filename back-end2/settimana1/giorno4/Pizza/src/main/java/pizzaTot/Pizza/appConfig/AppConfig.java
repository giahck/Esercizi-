package pizzaTot.Pizza.appConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pizzaTot.Pizza.Enum.EnumGradoAl;
import pizzaTot.Pizza.bean.Bevanda;

@Configuration
public class AppConfig {
    @Bean
    public Bevanda bevanda(){
        Bevanda b1=new Bevanda();
        b1.setNome("Birra");
        b1.setLt(5);
        b1.setGradoAlcohol(EnumGradoAl.META);

        return b1;

    }
}
