package blog.app_blog.controller;


import blog.app_blog.model.Blog;
import blog.app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "/blog/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blogs", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog , RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("mess","Thêm mới thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog , RedirectAttributes redirect){
        blogService.update(blog);
        redirect.addFlashAttribute("mess","Chỉnh sửa thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , RedirectAttributes redirect){
        blogService.remove(id);
        redirect.addFlashAttribute("mess","Xoá thành công!");
        return "redirect:/blog";
    }
}
