package services;

import data.entity.User;
import data.service.UserLoginServiceModel;

public interface UserService {
    void register(String username,String email,String password,String confirmPassword) throws Exception;

    User login(String username, String password);


}
