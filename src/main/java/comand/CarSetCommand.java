package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import entity.Car;
import entity.CarToUser;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarSetCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

            DaoFactory daoFactory = DaoFactory.getInstance();
            CarDao carDao = daoFactory.getCarDao();
            CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

            List<Car> carList =  carDao.getAllCar();
            request.getSession().setAttribute("allCars",carList);

            User user = (User) request.getSession().getAttribute("user");
            List<CarToUser> carListOfUser = carToUserDao.getUserCars(user.getId());

            request.getSession().setAttribute("clientCars",carListOfUser);

        return "userPage.jsp";
    }
}
