package Dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements  IDao{
    @Override
    public double getData() {
        return Math.random() * Math.PI * Math.E;
    }
}
