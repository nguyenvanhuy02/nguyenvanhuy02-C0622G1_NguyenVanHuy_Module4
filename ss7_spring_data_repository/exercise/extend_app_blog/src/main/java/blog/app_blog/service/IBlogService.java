package blog.app_blog.service;

import blog.app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(Integer id);
    void update ( Blog blog);
    void remove(int id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findName(String name , String category,Pageable pageable);
    List<Blog> findByAuthorContaining(String name);
}
