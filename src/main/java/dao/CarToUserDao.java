package dao;

import entity.Car;
import entity.CarToUser;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    public int addCarToUser(Car car, User user) {

        Connection connection ;
        PreparedStatement statement ;
        int result = 0;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into user_car(user_id,car_id)values(?,?)");

            statement.setInt(1,user.getId());
            statement.setInt(2,car.getId());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Set<CarToUser> getAll() {

        DaoFactory daoFactory  = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();

        Set<CarToUser> carToUsers = new HashSet<>();

        Connection connection ;
        PreparedStatement statement ;

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
    public List<CarToUser> getUserCars(int id) {

        DaoFactory daoFactory  = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();

        List<CarToUser> carToUsers = new ArrayList<>();

        Connection connection ;
        PreparedStatement statement ;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from user_car where user_id = ?");

            statement.setInt(1,id);

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

    public int deleteCarFromUserById(int id) {
        Connection connection;
        PreparedStatement statement;
        int result = 0;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("delete  from user_car where car_id = ?");

            statement.setInt(1,id);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteCarFromUserByUserIdAndCarId(int userId, int carId) {

        Connection connection ;
        PreparedStatement statement ;
        int result = 0;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("delete  from user_car where user_id = ? and car_id = ?");

            statement.setInt(1,userId);
            statement.setInt(2,carId);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Car getCarById(int carId) {
        Connection connection ;
        PreparedStatement statement;
        Car car = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from car where id = ?");

            statement.setInt(1,carId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                car = new Car();
                car.setId(carId);
                car.setName(rs.getString("name"));
                car.setPrice(rs.getInt("price"));
                car.setRented(rs.getBoolean("rent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}
