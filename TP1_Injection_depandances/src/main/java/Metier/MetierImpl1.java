package Metier;


import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MetierImpl1 implements IMetier{



    IDao dao;

    @Override
    public double calculate() {
        return dao.getData() + Math.random();
    }

    public void setDao(IDao dao){
        this.dao = dao;
    }
}
