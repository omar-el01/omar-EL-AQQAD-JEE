package Metier;

import Dao.IDao;
import org.springframework.stereotype.Component;


@Component("metierAnotatedConstructorInjection")
public class MetierImplAnnotated implements IMetier{


    IDao dao;
    public MetierImplAnnotated(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        return dao.getData() * Math.random();
    }
}
