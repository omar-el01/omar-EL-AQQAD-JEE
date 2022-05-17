package Dao;

public class DaoImpl implements  IDao{
    @Override
    public double getData() {
        return Math.random() * Math.PI * Math.E;
    }
}
