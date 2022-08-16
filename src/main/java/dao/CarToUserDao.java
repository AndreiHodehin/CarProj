package dao;

import entity.Car;
import entity.CarToUser;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CarToUserDao extends AbstractDao{

    private static CarToUserDao carToUserDao;
    private CarToUserDao() {

    }
    public static CarToUserDao getInstance(){
        if(carToUserDao == null) {
            return new CarToUserDao();
        }
        return carToUserDao;
    }

    public void addCarToUser(Car car, User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into user_car(user_id,car_id)values(?,?)");

            statement.setInt(1,user.getId());
            statement.setInt(2,car.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<CarToUser> getAll() {
        DaoFactory daoFactory  = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();

        Set<CarToUser> carToUsers = new HashSet<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from user_car");

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int uId = rs.getInt(1);
                int cId = rs.getInt(2);
                User user = userDao.getUserById(uId);
                Car car = carDao.getCarById(cId);
                CarToUser carToUser = new CarToUser();
                carToUser.setCar(car);
                carToUser.setUser(user);
                carToUsers.add(carToUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carToUsers;
    }
}
