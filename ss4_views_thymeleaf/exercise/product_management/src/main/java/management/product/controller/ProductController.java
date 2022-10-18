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
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("products",new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int) (Math.random()*10000));
        productService.save(product);
        redirect.addFlashAttribute("success","Add new success ");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update (Product product , RedirectAttributes redirect){
        productService.update(product.getId(),product);
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
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("products", productService.findByName(name));
        return "/list";
    }
}
