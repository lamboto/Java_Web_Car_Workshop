package services.base;

import data.dao.UserDaoImpl;
import data.entity.User;
import services.UserValidationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidationServiceImpl implements UserValidationService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean canCreateUser(String username, String email, String password, String confirmPassword) {
        return isEmailValid(email) &&
                arePasswordMatching(password, confirmPassword)
                && isUsernameNotTaken(username);
    }

    private boolean isUsernameNotTaken(String username) {
        User user = this.userDao.selectUserByUsername(username);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean arePasswordMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isEmailValid(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }


}
