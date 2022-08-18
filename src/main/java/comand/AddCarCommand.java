package comand;

import dao.CarDao;
import dao.DaoFactory;
import entity.Car;

import javax.servlet.http.HttpServletRequest;

public class AddCarCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        Car car = new Car();
        car.setName(name);
        car.setPrice(price);

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();

        carDao.addCar(car);
        return "addCar.jsp";
    }
}
