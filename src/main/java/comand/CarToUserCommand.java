package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.Car;
import entity.CarToUser;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CarToUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

        int carIdFromReq = Integer.parseInt(request.getParameter("CarId"));
        Car car = carDao.getCarById(carIdFromReq);
        if(car.isRented()){
            request.setAttribute("notAdd","This car are rents");
            return "userPage.jsp";
        }
        carDao.getRent(carIdFromReq);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);

        List<Car> carList = (List<Car>) carDao.getAllCar();
        request.getSession().setAttribute("allCars",carList);


        if(car != null){
            carToUserDao.addCarToUser(car,user);
            List<CarToUser> carListOfUser = carToUserDao.getInfoAboutUserCars(user.getId());
            request.getSession().setAttribute("clientCars",carListOfUser);
            return "userPage.jsp";
        }

        return "userPage.jsp";

    }
}
