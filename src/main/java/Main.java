import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.Car;
import entity.CarToUser;
import entity.User;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();
        UserDao userDao = daoFactory.getUserDao();


        int carId = 9;
        Car car = carDao.getCarById(carId);
        System.out.println(car);
    }
}
