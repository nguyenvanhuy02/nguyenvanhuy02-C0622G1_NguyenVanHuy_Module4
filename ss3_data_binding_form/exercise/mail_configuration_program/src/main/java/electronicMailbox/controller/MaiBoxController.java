package electronicMailbox.controller;

import electronicMailbox.model.Email;
import electronicMailbox.service.IMaiBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaiBoxController {
    @Autowired
    private IMaiBoxService maiBoxService;

    @GetMapping("/settings")
    public String showList(Model model) {
        model.addAttribute("languageList", maiBoxService.languages());
        model.addAttribute("pageSizeList", maiBoxService.pageSize());
        model.addAttribute("spamsFilterList", maiBoxService.spamsFilter());
        model.addAttribute("email", new Email());
        return "/list";
    }

    @PostMapping("/update")
    public String result(@ModelAttribute("updateEmail") Email email, Model model) {
        model.addAttribute("message", "Thay đổi thành công !");
        return "/update";
    }
}
