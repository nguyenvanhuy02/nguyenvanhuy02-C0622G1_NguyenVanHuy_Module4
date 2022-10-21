package blog.app_blog.service;

import blog.app_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
