package Dao;

public class DaoImplSensor implements IDao{


    @Override
    public double getData() {
        return Math.random() + Math.PI + Math.E;
    }
}
