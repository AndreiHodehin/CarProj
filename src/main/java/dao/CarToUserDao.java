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
    public List<CarToUser> getInfoAboutUserCars(int id) {
        DaoFactory daoFactory  = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();

        List<CarToUser> carToUsers = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

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

    public int deleteCarFromUser(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
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

    public int deleteCarFromUserAdminCommand(int userId,int carId) {
        Connection connection = null;
        PreparedStatement statement = null;
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
        Connection connection = null;
        PreparedStatement statement = null;
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
