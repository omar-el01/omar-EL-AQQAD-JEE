package Presentation;

import Dao.DaoImpl;
import Metier.MetierImpl1;

public class satatic_injection {


    public static void main(String[] args) {

        DaoImpl dao=new DaoImpl();

        MetierImpl1 metier=new MetierImpl1();

        metier.setDao(dao);

        System.out.println("\n Static injection result : "+ metier.calculate());
    }
}
