package management.product.controller;


import management.product.model.Product;
import management.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("product",new Product());
        return "/product/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("products",new Product());
        return "/product/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success","Add new success ");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/update")
    public String update (Product product , RedirectAttributes redirect){
        productService.update(product);
        redirect.addFlashAttribute("success","Update new success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , RedirectAttributes redirect){
        productService.remove(id);
        redirect.addFlashAttribute("success","Delete new success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("products", productService.findByName(name));
        return "/product/list";
    }
}
