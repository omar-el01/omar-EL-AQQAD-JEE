package Presentation;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringXmlInjection {


    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IMetier metier=(IMetier) applicationContext.getBean("metier");

        System.out.println("\n SpringXml injection result : "+ metier.calculate());
    }
}
