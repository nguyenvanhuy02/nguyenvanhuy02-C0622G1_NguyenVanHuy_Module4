package app.application_book.controller;

import app.application_book.model.Book;
import app.application_book.model.Oder;
import app.application_book.service.IBookService;
import app.application_book.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOderService oderService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "/book/list";
    }

    @GetMapping("/{id}/oder")
    public String oder(@PathVariable int id, RedirectAttributes redirect) throws Exception {


        Book book = bookService.findById(id);

        if (book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);


        //Tạo một oder mới và random code oder .
        Oder oder = new Oder();
        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        oder.setCode(code);

        //Lấy ngày hiện tại oder
        long millis = System.currentTimeMillis();
        oder.setDate(new java.sql.Date(millis));
        oderService.save(oder);


        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);
        bookService.save(book);

        redirect.addFlashAttribute("mess", "Oder thành công mã của bạn :" + oder.getCode());

        return "redirect:/list";
    }


    @PostMapping("/update")
    public String pay(@RequestParam(value = "pay") long code, RedirectAttributes redirect) {
        Book book = bookService.findByCode(code);
        Oder oder = oderService.findByCode(code);
        if (book == null) {
            return "/book/error";
        } else {
            book.setCount(book.getCount() + 1);
            bookService.save(book);
            oder.setCode(0);
            oderService.save(oder);
            redirect.addFlashAttribute("mess", "Bạn đã trả sách thành công!");
        }
        return "redirect:/list";

    }

    @ExceptionHandler(Exception.class)
    public String handlerError(Exception e) {
        return "/book/error";
    }
}
