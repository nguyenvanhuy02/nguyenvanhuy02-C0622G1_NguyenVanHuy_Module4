package blog.app_blog.service;


import blog.app_blog.model.Blog;
import blog.app_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    void save(Category category);
    Category findById(Integer id);
    void update ( Category category);
    void remove(int id);
}
