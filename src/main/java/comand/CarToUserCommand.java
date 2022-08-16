package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.Car;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CarToUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

        int carIdFromReq = Integer.parseInt(request.getParameter("CarId"));
        Car car = carDao.getCarById(carIdFromReq);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);


        if(car != null){
            carToUserDao.addCarToUser(car,user);
            return "main.jsp";
        }
        return "main.jsp";

    }
}
