package login.service;

import login.model.Login;
import login.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User checkLogin(Login login);
}
