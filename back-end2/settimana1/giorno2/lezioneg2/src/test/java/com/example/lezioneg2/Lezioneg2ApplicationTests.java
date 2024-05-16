package com.example.lezioneg2;

import com.example.lezioneg2.bean.Aula;
import com.example.lezioneg2.bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Lezioneg2ApplicationTests {
	static ApplicationContext ctx;

	@BeforeAll
	public static void accediAlContesto() {
		ctx = new AnnotationConfigApplicationContext(Lezioneg2Application.class);
		System.out.println("Contesto caricato");
	}
	@Test
	void verificanomePrimoStudente() {
		Studente s1 = ctx.getBean("Mario", Studente.class);
		Assertions.assertEquals("Marcodf", s1.getNome());
	}
	@Test
	void verficaAulaNotNull() {
		Aula aula = ctx.getBean(Aula.class);
		Assertions.assertNotNull(aula);
	}
	@Test
	public void verificaNumeroStudentiInaula(){
		Aula aula = ctx.getBean(Aula.class);
		Assertions.assertEquals(2, aula.getStudenti().size());
	}
	@AfterAll
	public static void chiudiContesto() {
		ctx=null;
		System.out.println("Contesto chiuso");
	}

}
