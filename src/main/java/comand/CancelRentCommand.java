package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.Car;
import entity.CarToUser;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CancelRentCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

        int carId = Integer.parseInt(request.getParameter("carId"));
        carDao.cancelTheRent(carId);
        carToUserDao.deleteCarFromUser(carId);

        User user = (User) request.getSession().getAttribute("user");
        List<CarToUser> carListOfUser = carToUserDao.getInfoAboutUserCars(user.getId());

        List<Car> carList = (List<Car>) carDao.getAllCar();
        request.getSession().setAttribute("allCars",carList);

        request.getSession().setAttribute("clientCars",carListOfUser);

        return "userPage.jsp";
    }
}
