package blog.app_blog.controller;

import blog.app_blog.dto.BlogDto;
import blog.app_blog.model.Blog;
import blog.app_blog.model.Category;
import blog.app_blog.service.IBlogService;
import blog.app_blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog/v1")
public class RestBlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    //Lấy tài nguyên
    @GetMapping
    public ResponseEntity<List<Blog>> getList(@PageableDefault(value = 5) Pageable pageable){
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage.getContent(), HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<List<Blog>> getBlogList() {
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto , Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(
            @PathVariable int id,
            @RequestBody BlogDto blogDto
    ) {
        Blog blogEdited = blogService.findById(id);
        if (blogEdited == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blog.setId(blogEdited.getId());
        blogService.save(blog);

        return new ResponseEntity<>(blogEdited, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity view(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam String name){
        List<Blog> blogs = blogService.findByAuthorContaining(name);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


}
