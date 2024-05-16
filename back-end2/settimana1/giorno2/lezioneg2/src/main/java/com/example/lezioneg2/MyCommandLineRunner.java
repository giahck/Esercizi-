package com.example.lezioneg2;

import com.example.lezioneg2.bean.Aula;
import com.example.lezioneg2.bean.Scuola;
import com.example.lezioneg2.bean.Smartphon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Lezioneg2Application.class);
        Aula aula= ctx.getBean(Aula.class);
        System.out.println(aula);

        Smartphon smartphon1= ctx.getBean("smartphone1", Smartphon.class);
        System.out.println(smartphon1);

        Scuola scuola= ctx.getBean(Scuola.class);
        System.out.println(scuola);
    }
}
