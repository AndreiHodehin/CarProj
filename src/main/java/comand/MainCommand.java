package comand;



import javax.servlet.http.HttpServletRequest;


public class MainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return "main.jsp";
    }
}
