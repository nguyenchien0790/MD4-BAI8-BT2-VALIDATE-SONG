package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rikkei.academy.model.Song;
import rikkei.academy.service.SongService;

@Controller
public class SongController {
    private SongService songService = new SongService();

    @GetMapping("/")
    public  String home(Model model){
        model.addAttribute("songs",songService.findAll());
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("song",new Song());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Song song){
        int lastIndex = songService.findAll().size()-1;
        int lastId = songService.findAll().get(lastIndex).getId();
        song.setId(lastId+1);
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song",song);
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Song song ){
        songService.update(song);
        return "redirect:/";
    }



}
