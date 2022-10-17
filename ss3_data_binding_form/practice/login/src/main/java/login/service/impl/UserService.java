package login.service.impl;

import login.model.Login;
import login.model.User;
import login.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements IUserService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",15));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",16));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User checkLogin(Login login) {
        for (User u : users){
            if (u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
