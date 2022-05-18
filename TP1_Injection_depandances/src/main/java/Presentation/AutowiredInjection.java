package Presentation;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredInjection {

    public static void main(String[] args) throws  Exception {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("Dao","Metier");
        IMetier metier=(IMetier) applicationContext.getBean("metierAutowiredInjection");

        System.out.println( "\n Spring autowired injection result : "+ metier.calculate());

    }
}
