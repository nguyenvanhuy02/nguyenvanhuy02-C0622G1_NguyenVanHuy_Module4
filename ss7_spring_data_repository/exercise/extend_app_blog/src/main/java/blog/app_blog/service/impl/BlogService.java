package blog.app_blog.service.impl;

import blog.app_blog.model.Blog;
import blog.app_blog.repository.IBlogRepository;
import blog.app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findName(String name, String category, Pageable pageable) {
        return blogRepository.findByNameAndByCategory(name , category , pageable);
    }

    @Override
    public List<Blog> findByAuthorContaining(String name) {
        return blogRepository.findByAuthorContaining(name);
    }


}
