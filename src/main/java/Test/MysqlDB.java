package Test;

public class MysqlDB implements AbstractDB{
    @Override
    public void insert() {
        System.out.println("MySQL insert");
    }
    @Override
    public void delete() {
        System.out.println("MySQL delete");
    }
    @Override
    public void update() {
        System.out.println("MySQL update");
    }

}
