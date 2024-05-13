package it.M2_S1_G1.spring1.AppConfig;

import it.M2_S1_G1.spring1.bean.Aula;
import it.M2_S1_G1.spring1.bean.Computer;
import it.M2_S1_G1.spring1.bean.Smartphon;
import it.M2_S1_G1.spring1.bean.Studente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean("Mario")
    @Primary//se ho più bean dello stesso tipo, questo è il bean di default
   // @Scope("prototype")//ogni volta che chiamo il metodo getStudente mi crea un nuovo oggetto
    public Studente getStudente() {
        Studente studente = new Studente();
        studente.setNome("Mario");
        studente.setCognome("Rossi");
        studente.setIndirizzo("Via Roma 1");
        studente.setDispositivi(List.of(getComputer(),getSmartphon()));
        return studente;
    }
    @Bean("Giuseppe")
    public Studente getStudente2() {
        Studente studente = new Studente();
        studente.setNome("Giuseppe");
        studente.setCognome("Rotondo");
        studente.setIndirizzo("Via Palermo 2");
        studente.setDispositivi(List.of(getComputer2()));
        return studente;
    }
    @Bean
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setNome("Computer");
        computer.setMarca("Asus");
        computer.setMonitor(24);
        computer.setRam(16);
        computer.setCpu("Intel i7");
        return computer;
    }
    @Bean
    public Computer getComputer2() {
        Computer computer = new Computer();
        computer.setNome("Computer");
        computer.setMarca("Dell");
        computer.setMonitor(15);
        computer.setRam(30);
        computer.setCpu("Intel i9");
        return computer;
    }
    @Bean
    public Smartphon getSmartphon() {
        Smartphon smartphon = new Smartphon();
        smartphon.setNome("Smartphon");
        smartphon.setMarca("Samsung");
        smartphon.setSchermo(6);
        smartphon.setSistemaOperativo("Android");
        return smartphon;
    }
    @Bean
    public Aula getAula() {
        Aula aula = new Aula();
        aula.setNome("Aula 1");
        aula.setStudenti(List.of(getStudente(), getStudente2()));
        return aula;
    }

}
