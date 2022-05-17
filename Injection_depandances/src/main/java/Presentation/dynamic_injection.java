package Presentation;

import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class dynamic_injection {


    public static void main(String[] args) throws Exception {

        Scanner scanner=new Scanner(new File("config"));
        String DaoClass=scanner.nextLine();
        Class CDao=Class.forName(DaoClass);
        IDao dao=(IDao) CDao.newInstance();

        String MetierClass=scanner.nextLine();
        Class CMetier=Class.forName(MetierClass);
        IMetier metier=(IMetier) CMetier.newInstance();

        Method method=CMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);

        System.out.println("\n Dynamic injection result : "+ metier.calculate());
    }
}
