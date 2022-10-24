package from.user.service;


import from.user.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
