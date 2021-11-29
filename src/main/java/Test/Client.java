package Test;



public class Client {
    AbstractDB dao;

    public Client() {
        dao = FactoryDB.getDB();
    }
    public AbstractDB getDao() {
        return dao;
    }
    public void setDao(AbstractDB dao) {
        this.dao = dao;
    }

    public void execute() {
        dao.insert();
        dao.update();
        dao.delete();
    }
}
