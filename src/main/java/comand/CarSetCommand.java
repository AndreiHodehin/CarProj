package comand;

import dao.CarDao;
import dao.DaoFactory;
import entity.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarSetCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

            DaoFactory daoFactory = DaoFactory.getInstance();
            CarDao carDao = daoFactory.getCarDao();
            List<Car> carList = (List<Car>) carDao.getAllCar();
            request.setAttribute("allCars", carList);
            return "carToUser.jsp";
    }
}
