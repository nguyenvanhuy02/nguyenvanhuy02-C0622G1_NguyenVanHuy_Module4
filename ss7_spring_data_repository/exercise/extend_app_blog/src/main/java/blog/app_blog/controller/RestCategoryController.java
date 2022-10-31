package blog.app_blog.controller;

import blog.app_blog.dto.CategoryDto;
import blog.app_blog.model.Blog;
import blog.app_blog.model.Category;
import blog.app_blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
public class RestCategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showCategory(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity editCategory(
            @PathVariable int id ,
            @RequestBody CategoryDto categoryDto){
        Category categoryId = categoryService.findById(id);
        if (categoryId == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        category.setId(categoryId.getId());
        categoryService.save(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity view(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
