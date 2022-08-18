package comand;

import dao.DaoFactory;
import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class AllUsersCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();

        String param = request.getParameter("userId");
        if(param != null){
            System.out.println("all works good");
            int paramInt =Integer.parseInt(param);
            int result = userDao.deleteUserById(paramInt);
            if(result == 0){
                request.setAttribute("notDeleted","You cant delete this user");
            }
        }

        Set<User> userSet = userDao.getAllUser();
        request.setAttribute("allUsers", userSet);
        return "allUsers.jsp";
    }
}
