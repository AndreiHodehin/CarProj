package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import entity.Car;
import entity.CarToUser;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarToUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();
        int carIdFromReq = -1;

        try {
             carIdFromReq = Integer.parseInt(request.getParameter("CarId"));
        } catch (NumberFormatException e){
            e.getCause();
            request.setAttribute("notAdd","Please insert correct value");
            return "userPage.jsp";
        }

        Car car = carDao.getCarById(carIdFromReq);
        if(car == null || car.isRented()){
            request.setAttribute("notAdd","You cant rent this car");
            return "userPage.jsp";
        }

        carDao.getRent(carIdFromReq);
        List<Car> carList = carDao.getAllCar();
        request.getSession().setAttribute("allCars",carList);


        User user = (User) request.getSession().getAttribute("user");
        carToUserDao.addCarToUser(car,user);
        List<CarToUser> carListOfUser = carToUserDao.getUserCars(user.getId());
        request.getSession().setAttribute("clientCars",carListOfUser);

        return "userPage.jsp";

    }
}
