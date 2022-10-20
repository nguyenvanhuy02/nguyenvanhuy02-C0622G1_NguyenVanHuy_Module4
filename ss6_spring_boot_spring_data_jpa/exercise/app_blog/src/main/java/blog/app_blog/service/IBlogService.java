package blog.app_blog.service;

import blog.app_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(Integer id);
    void update ( Blog blog);
    void remove(int id);
}
