package music.song_information.controller;

import music.song_information.dto.MusicDto;
import music.song_information.model.Music;
import music.song_information.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "/music/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("musicList", new MusicDto());
        return "/music/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("musicList") MusicDto musicDto,
                       BindingResult bindingResult , RedirectAttributes redirect){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/music/create";
        }else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            musicService.save(music);
            redirect.addFlashAttribute("mess","Thêm mới thành công !");
            return "redirect:/list";
        }
    }
}
