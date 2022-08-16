package comand;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SAAJResult;

public class LoginCommand implements  Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.getUserByNamePass(name,password);

        String result = (user == null) ? "login.jsp" : "controller?action=main";

        if(user == null) {
            request.setAttribute("notExists", "this user not exist");
        } else {
            request.getSession().setAttribute("user", user);
        }
        return result;
    }
}
