package services.base;

import config.DataBaseConnector;
import data.dao.UserDaoImpl;
import data.entity.User;
import data.service.UserLoginServiceModel;
import org.modelmapper.ModelMapper;
import query.Query;
import services.UserService;

import java.sql.*;

public class UserServiceImpl implements UserService {

    private final ModelMapper mapper = new ModelMapper();
    private final UserValidationServiceImpl userValidationService = new UserValidationServiceImpl();
    private final UserDaoImpl userDao = new UserDaoImpl();


    @Override
    public void register(String username, String email, String password, String confirmPassword) throws Exception {
        if (!userValidationService.canCreateUser(username, email, password, confirmPassword)) {
            throw new Exception("User cannot be created");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        this.userDao.register(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.selectUserByUsername(username);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }


}
