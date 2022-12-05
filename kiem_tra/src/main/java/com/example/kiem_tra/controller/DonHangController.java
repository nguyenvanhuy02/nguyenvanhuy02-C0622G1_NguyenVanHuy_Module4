package com.example.kiem_tra.controller;

import com.example.kiem_tra.model.DonHang;
import com.example.kiem_tra.service.IDonHangService;
import com.example.kiem_tra.service.ILoaiSanPhamService;
import com.example.kiem_tra.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/donhang")
public class DonHangController {

    @Autowired
    private IDonHangService donHangService;

    @Autowired
    private ILoaiSanPhamService loaiSanPhamService;

    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping
    public String showList(@PageableDefault(value = 2)Pageable pageable,
                           Model model){
        model.addAttribute("dSDonHang",donHangService.findAll(pageable));
        return "/don_hang/danh_sach";
    }

    @GetMapping("/{id}/edit")
    public String sua(@PathVariable int id,Model model){
        model.addAttribute("donHang",donHangService.findById(id));
        model.addAttribute("loaiSP",loaiSanPhamService.findAll());
        model.addAttribute("sanPhamDS",sanPhamService.findAll());
        return "/don_hang/chinh_sua";
    }

    @PostMapping("/update")
    public String update(DonHang donHang, RedirectAttributes redirect){
        donHangService.save(donHang);
        redirect.addFlashAttribute("mess","chỉnh sửa thành công!");
        return "redirect:/donhang";
    }
}
