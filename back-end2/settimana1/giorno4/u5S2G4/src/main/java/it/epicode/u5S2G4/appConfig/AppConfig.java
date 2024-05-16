package it.epicode.u5S2G4.appConfig;




import it.epicode.u5S2G4.bean.Computer;
import it.epicode.u5S2G4.bean.Smartphone;
import it.epicode.u5S2G4.bean.Studente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${studente1.nome}")
    private String nomeStudente1;

    @Value("${studente1.cognome}")
    private String cognomeStudente1;

    @Bean("Carla")
    @Primary
    public Studente getStudente() {
        Studente studente = new Studente();
        studente.setNome(nomeStudente1);
        studente.setCognome(cognomeStudente1);
        studente.setIndirizzo("Via Roma");
        studente.setDispositivi(List.of(getComputer(), getSmartphone()));
        return studente;
    }

    @Bean("Francesca")
    public Studente getStudente2() {
        Studente studente = new Studente();
        studente.setNome("Francesca");
        studente.setCognome("Polli");
        studente.setIndirizzo("Via Roma");
        return studente;
    }

    @Bean
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setNome("X1");
        computer.setMarca("HP");
        computer.setCpu("Intel");
        computer.setRam(16);
        computer.setMonitor(27);
        return computer;
    }

    @Bean
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome("S23");
        smartphone.setMarca("Samsung");
        smartphone.setSchermo(6);
        return smartphone;
    }
    //@Bean
//    public Aula getAula(){
//        Aula aula = new Aula();
//        aula.setNome("A1");
//        aula.setStudenti(List.of(getStudente(), getStudente2()));
//        return aula;
//    }
}
