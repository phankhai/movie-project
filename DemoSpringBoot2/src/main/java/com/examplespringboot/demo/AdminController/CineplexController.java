package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.Cineplex;
import com.examplespringboot.demo.Service.Impl.CineplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/cineplex")
public class CineplexController {

    @Autowired
    private CineplexService cineplexService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("cines",cineplexService.findAll());
        return "admin/cineplex";
    }

    @GetMapping("add")
    public String cineAdd(HttpSession httpSession, @ModelAttribute("cineplex") Cineplex cineplex
            , ModelMap modelMap) {
        modelMap.addAttribute("cineplex",new Cineplex());
        return "admin/cineplex-add";
    }

    @PostMapping("add")
    public String postCine(@RequestParam("logo") MultipartFile file, ModelMap modelMap,
                           RedirectAttributes redirectAttributes, HttpSession httpSession
            , @ModelAttribute("cineplex")Cineplex cineplex, BindingResult result){
        if(cineplex.getName() == null || cineplex.getName().equals("")){
            modelMap.addAttribute("errname","tên không rỗng");
            return "admin/cineplex-add";
        }
        else if(file.getSize() == 0){
            String error = "file không rỗng";
            modelMap.addAttribute("errfile",error);
            return "admin/cineplex-add";
        }else{
            cineplex.setLogo("/upload/"+file.getOriginalFilename());
            cineplexService.insert(cineplex);
            redirectAttributes.addFlashAttribute("success","thêm thành công");
            return "redirect:/admin/cineplex";
        }
    }



}
