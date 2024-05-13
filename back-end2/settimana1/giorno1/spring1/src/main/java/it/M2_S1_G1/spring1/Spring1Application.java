package it.M2_S1_G1.spring1;

import it.M2_S1_G1.spring1.AppConfig.AppConfig;
import it.M2_S1_G1.spring1.bean.Aula;
import it.M2_S1_G1.spring1.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
		//accediamo al contesto dell'applicazione con spring
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//recuperiamo il bean studente
		Studente studente= ctx.getBean("Mario",Studente.class);
		Studente studente2= ctx.getBean("Giuseppe",Studente.class);
		Aula aula= ctx.getBean(Aula.class);
		System.out.println(studente+"\n"+studente2+"\n"+aula);
	/*	Studente studente1A= ctx.getBean(Studente.class);
		Studente studente2A= ctx.getBean(Studente.class);
		studente1A.setNome("Rosario");
		System.out.println(studente1A+"\n"+studente2A);*/
	}


}
