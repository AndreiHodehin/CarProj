package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;

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
        int carId = -1;

        try {
            carId = Integer.parseInt(request.getParameter("carId"));
        } catch (NumberFormatException e) {
            e.getCause();
            request.setAttribute("notDeleted","Please insert correct value");
            return "userPage.jsp";
        }

        carDao.cancelTheRent(carId);
        carToUserDao.deleteCarFromUserById(carId);

        User user = (User) request.getSession().getAttribute("user");
        List<CarToUser> carListOfUser = carToUserDao.getUserCars(user.getId());

        List<Car> carList = carDao.getAllCar();
        request.getSession().setAttribute("allCars",carList);

        request.getSession().setAttribute("clientCars",carListOfUser);

        return "userPage.jsp";
    }
}
