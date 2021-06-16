package data.dao;

import data.entity.User;
import data.service.UserLoginServiceModel;

public interface UserDao {

    void register(User user);

    User selectUserByUsername(String username);

}
