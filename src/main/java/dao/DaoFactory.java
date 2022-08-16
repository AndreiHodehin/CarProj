package dao;

public class DaoFactory {

    private static DaoFactory factory;

    private DaoFactory() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getInstance() {
        if(factory == null) {
            factory = new DaoFactory();
        }
        return factory;
    }

    public CarDao getCarDao() {return CarDao.getInstance();}
    public UserDao getUserDao() {return UserDao.getInstance();}
    public CarToUserDao getCarToUserDao() {return CarToUserDao.getInstance();  }
}
