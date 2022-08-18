package comand;

import dao.CarDao;
import dao.CarToUserDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.CarToUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class AdminStopRentCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        CarDao carDao = daoFactory.getCarDao();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();

        int userId = Integer.parseInt(request.getParameter("userId"));
        int carId = Integer.parseInt(request.getParameter("carId"));

        carDao.cancelTheRent(carId);
        carToUserDao.deleteCarFromUserAdminCommand(userId,carId);
        Set<CarToUser> allInfo = carToUserDao.getAll();
        request.getSession().setAttribute("allInfo",allInfo);

        return "allInfo.jsp";
    }
}
