package blog.app_blog.controller;


import blog.app_blog.model.Blog;
import blog.app_blog.service.IBlogService;
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


@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String list(@RequestParam(value = "page" , defaultValue = "0") int page , Model model) {
        Sort sort = Sort.by("author").ascending();
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page,5,sort));
        model.addAttribute("blogs", blogPage);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogs", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.update(blog);
        redirect.addFlashAttribute("mess", "Chỉnh sửa thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("mess", "Xoá thành công!");
        return "redirect:/blog";
    }

}
