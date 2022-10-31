package blog.app_blog.controller;

import blog.app_blog.dto.BlogDto;
import blog.app_blog.model.Blog;
import blog.app_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/v1")
public class RestBlogController {
    @Autowired
    IBlogService blogService;

    //Lấy tài nguyên
    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto) {
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
}
