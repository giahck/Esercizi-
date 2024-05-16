package it.epicode.u5S2G4;

import it.epicode.u5S2G4.bean.Computer;
import it.epicode.u5S2G4.bean.Scuola;
import it.epicode.u5S2G4.bean.Smartphone;
import it.epicode.u5S2G4.bean.Studente;
import it.epicode.u5S2G4.service.DispositivoService;
import it.epicode.u5S2G4.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MuCommandLineRunner implements CommandLineRunner {
    @Autowired
    private StudenteService studenteService;
    @Autowired
    private DispositivoService dispositivoService;
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(U5S2G4Application.class);

       /* Studente studente1 = ctx.getBean("Carla", Studente.class);
        studenteService.inserisciStudente(studente1);

        Studente studente2 = ctx.getBean("Francesca", Studente.class);
        studenteService.inserisciStudente(studente2);

        Computer computer = ctx.getBean(Computer.class);
        computer.setStudente(studente1);
        dispositivoService.inserisciDispositivo(computer);

        Smartphone smartphone = ctx.getBean(Smartphone.class);
        smartphone.setStudente(studente2);
        dispositivoService.inserisciDispositivo(smartphone);*/

       // System.out.println(dispositivoService.getDispositiviOrderByNome());
        System.out.println(dispositivoService.findByRamLessThannome());


    }

}
