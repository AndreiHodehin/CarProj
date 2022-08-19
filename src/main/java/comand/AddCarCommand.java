package comand;

import dao.CarDao;
import dao.DaoFactory;
import entity.Car;

import javax.servlet.http.HttpServletRequest;

public class AddCarCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        int price = 0;

        try {
            price = Integer.parseInt(request.getParameter("price"));
        } catch (NumberFormatException e) {
            e.getCause();
            request.setAttribute("badInput","Please insert correct value");
            return "addCar.jsp";
        }

        Car car = new Car();
        car.setName(name);
        car.setPrice(price);

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarDao carDao = daoFactory.getCarDao();
        carDao.addCar(car);

        return "addCar.jsp";
    }
}
