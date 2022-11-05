package blog.app_blog.service;

import blog.app_blog.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
}
