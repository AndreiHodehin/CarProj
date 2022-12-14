package dao;

import entity.CarToUser;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDao extends AbstractDao{


    private static UserDao userDao;

    private UserDao() {

    }
    public static UserDao getInstance() {
        if(userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public User addUser(User user) {

        Connection connection ;
        PreparedStatement statement ;

        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into user (name,password,admin)values (?,?,?)");

            statement.setString(1,user.getName());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());

            statement.executeUpdate();

            ResultSet rs = statement.executeQuery("select max(id)from user");
            rs.next();
            int userId = rs.getInt(1);
            user.setId(userId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserById(int id) {

        Connection connection;
        PreparedStatement statement;

        User user = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from user where id = ?");

            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            rs.next();

            user = new User();
            user.setId(id);
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAdmin(rs.getBoolean("admin"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByNamePass(String name,String password) {

        Connection connection;
        PreparedStatement statement;

        User user = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select id,admin from user where name = ? and password = ?");

            statement.setString(1,name);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {

                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(name);
                user.setPassword(password);
                user.setAdmin(rs.getBoolean("admin"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Set<User> getAllUser() {
        Connection connection;
        PreparedStatement statement;

        Set<User> userSet = new HashSet<>();

        try{
            connection = getConnection();
            statement = connection.prepareStatement("select * from user");

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("admin"));

                userSet.add(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return userSet;
    }

    public int deleteUserById(int userId) {

        Connection connection;
        PreparedStatement statement;
        int result = 0;

        DaoFactory daoFactory = DaoFactory.getInstance();
        CarToUserDao carToUserDao = daoFactory.getCarToUserDao();
        List<CarToUser> list = carToUserDao.getUserCars(userId);
        if(!list.isEmpty()){return result;}

        try{
            connection = getConnection();
            statement = connection.prepareStatement("delete from user where id = ?");

            statement.setInt(1,userId);

            result = statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
