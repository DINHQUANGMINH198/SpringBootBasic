package Test;

public class MongoDB implements AbstractDB{
    @Override
    public void insert() {
        System.out.println("MongoDB insert");
    }
    @Override
    public void delete() {
        System.out.println("MongoDB delete");
    }
    @Override
    public void update() {
        System.out.println("MongoDB update");
    }
}
