package dao;

import entity.Car;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends AbstractDao {

    private static CarDao instance;

    private CarDao() {

    }

    public static CarDao getInstance() {
        if (instance == null) {
            instance = new CarDao();
        }
        return instance;
    }

    public Car addCar(Car car) {

        Connection connection ;
        PreparedStatement preparedStatement ;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into car(name,price)values (?,?)");

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getPrice());

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("select id from car where name= ?");

            preparedStatement.setString(1,car.getName());

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            car.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    public List<Car> getAllCar() {

        List<Car> cars = new ArrayList<>();

        Connection connection ;
        PreparedStatement statement ;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from car");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                boolean rent = rs.getBoolean("rent");

                Car car = new Car();
                car.setId(id);
                car.setName(name);
                car.setPrice(price);
                car.setRented(rent);
                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public Car getCarById(int id) {

        Car car = null;

        Connection connection ;
        PreparedStatement statement ;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from car where id =?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            rs.next();

            car = new Car();
            car.setId(id);
            car.setName(rs.getString("name"));
            car.setPrice(rs.getInt("price"));
            car.setRented(rs.getBoolean("rent"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return car;
    }

    public Car getCarByName(String name) {

        Car car = new Car();

        Connection connection ;
        PreparedStatement statement ;

        try {

            connection = getConnection();
            statement = connection.prepareStatement("select * from car where name =?");

            statement.setString(1,name);

            ResultSet rs = statement.executeQuery();

            rs.next();
            car.setId(rs.getInt("id"));
            car.setName(rs.getString("name"));
            car.setPrice(rs.getInt("price"));
            car.setRented(rs.getBoolean("rent"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public void getRent(int id) {

        Connection connection ;
        PreparedStatement statement ;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("update  car set rent = true where id = ?");

            statement.setInt(1,id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelTheRent(int id) {

        Connection connection ;
        PreparedStatement statement ;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("update  car set rent = false where id = ?");

            statement.setInt(1,id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int deleteCarByCarId(int carId) {

        Connection connection ;
        PreparedStatement statement ;
        int result = 0;

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();
        Car car = carToUserDao.getCarById(carId);
        if(car == null || car.isRented()) {
            return result;
        }

        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from car where id = ?");

            statement.setInt(1,carId);

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
