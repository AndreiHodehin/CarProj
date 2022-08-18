package comand;

import dao.CarDao;
import dao.DaoFactory;
import entity.Car;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");


//            CarDao carDao = daoFactory.getCarDao();
//            List<Car> carList = (List<Car>) carDao.getAllCar();
//            request.setAttribute("allCars", carList);


        return "main.jsp";
    }
}
