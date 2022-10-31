package blog.app_blog.controller;

import blog.app_blog.model.Blog;
import blog.app_blog.model.Category;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList", new Category());
        return "/category/create";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirect) {
        categoryService.update(category);
        redirect.addFlashAttribute("mess", "Chỉnh sửa thành công!");
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        categoryService.remove(id);
        redirect.addFlashAttribute("mess", "Xoá thành công!");
        return "redirect:/category/list";
    }
}
