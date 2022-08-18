package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import entity.Car;
import entity.CarToUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllCarsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

        String carIdStr = request.getParameter("carId");

        if(carIdStr != null) {
            int carId = Integer.parseInt(carIdStr);
            int deleted = carDao.deleteCarByCarId(carId);
            if(deleted == 0) {
                request.setAttribute("notDeleted","You cant delete this car");
            }
        }
        List<Car> carList = carDao.getAllCar();
        request.setAttribute("allCars",carList);
        return "allCars.jsp";
    }
}
