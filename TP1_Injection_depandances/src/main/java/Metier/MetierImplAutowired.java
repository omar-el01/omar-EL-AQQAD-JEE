package Metier;

import Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MetierImplAutowired implements IMetier{

    private  IDao dao;

@Autowired
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        return dao.getData() * Math.random();
    }
}
