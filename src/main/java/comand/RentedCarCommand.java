package comand;

import dao.CarToUserDao;
import dao.DaoFactory;
import entity.CarToUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class RentedCarCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();
        Set<CarToUser> allInfo = carToUserDao.getAll();
        request.getSession().setAttribute("allInfo",allInfo);
        return "allInfo.jsp";
    }
}
