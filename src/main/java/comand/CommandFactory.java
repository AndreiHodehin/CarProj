package comand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory commandFactory ;

    private CommandFactory() {

    }
    private Map<String,Command> commands = new HashMap<>();

    {   commands.put("addCar",new AddCarCommand());
        commands.put("main",new MainCommand());
        commands.put("register" , new RegisterCommand());
        commands.put("carToUser", new CarToUserCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("login", new LoginCommand());
        commands.put("carsSet" , new CarSetCommand());
        commands.put("getRentedCar", new RentedCarCommand());
        commands.put("cancelRent", new CancelRentCommand());
        commands.put("adminStopRent", new AdminStopRentCommand());
        commands.put("allCars",new AllCarsCommand());
        commands.put("allUsers", new AllUsersCommand());
    }

    public static CommandFactory getInstance(){
        if(commandFactory == null){
            return new CommandFactory();
        }
        return commandFactory;
    }

    public Command getCommand(HttpServletRequest req) {
        String action = req.getParameter("action");
        Command command = commands.get(action);
        return command;
    }
}
