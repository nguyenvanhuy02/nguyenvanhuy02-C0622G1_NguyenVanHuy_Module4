package blog.app_blog.controller;


import blog.app_blog.model.Blog;
import blog.app_blog.model.Category;
import blog.app_blog.service.IBlogService;
import blog.app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String home(){
        return "/home";
    }

//    @GetMapping("/list")
//    public String list(@RequestParam(value = "page" , defaultValue = "0") int page , Model model,
//                       @PageableDefault(value = 1) Pageable pageable) {
//        Sort sort = Sort.by("dateCreate").ascending();
//        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,5,sort));
//        model.addAttribute("blogs", blogPage);
//        return "/blog/list";
//    }
    @GetMapping("/list")
    public String searchByName(@RequestParam (value = "name" , defaultValue = "") String name ,
                                @RequestParam(value = "category" ,defaultValue = "") String category,
                               @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Blog> blogs = blogService.findName(name,category,pageable);
        model.addAttribute("blogs", blogs);
        model.addAttribute("name",name);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blogs", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blog.setDateCreate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirect.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blog.setDateCreate(new Date(System.currentTimeMillis()));
        blogService.update(blog);
        redirect.addFlashAttribute("mess", "Chỉnh sửa thành công!");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("mess", "Xoá thành công!");
        return "redirect:/blog/list";
    }

//    @GetMapping("/search")
//    public String search (@RequestParam (value = "name") String name ,
//                          @RequestParam(value = "category") String category , Model model ,
//                          @PageableDefault(value = 1) Pageable pageable){
//        Page<Blog> blogList = blogService.findName(name , category,pageable);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("blogs", blogList);
//        model.addAttribute("categoryList", categoryList);
//        return "/blog/list";
//    }
}
