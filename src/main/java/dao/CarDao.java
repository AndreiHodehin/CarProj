package dao;

import entity.Car;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into car(name,price)values (?,?)");

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getPrice());

            int result = preparedStatement.executeUpdate();

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

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from car");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                Car car = new Car();
                car.setId(id);
                car.setName(name);
                car.setPrice(price);
                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public Car getCarById(int id) {
        Car car = new Car();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from car where id =?");

            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();
            rs.next();

            car.setId(id);
            car.setName(rs.getString("name"));
            car.setPrice(rs.getInt("price"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public Car getCarByName(String name) {
        Car car = new Car();

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = getConnection();
            statement = connection.prepareStatement("select * from car where name =?");

            statement.setString(1,name);

            ResultSet rs = statement.executeQuery();

            rs.next();
            car.setId(rs.getInt("id"));
            car.setName(rs.getString("name"));
            car.setPrice(rs.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}
