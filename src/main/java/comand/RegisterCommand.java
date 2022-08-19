package comand;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RegisterCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAdmin(Boolean.parseBoolean(request.getParameter("admin")));

        Set<User> userSet = userDao.getAllUser();
        User checkUser = userDao.getUserByNamePass(name,password);


        if (!userSet.contains(checkUser)) {
            userDao.addUser(user);
            System.out.println("user is registered");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "main.jsp";
        } else {
            request.setAttribute("notAdd", "User is exist");
            return "register.jsp";
        }


    }
}
