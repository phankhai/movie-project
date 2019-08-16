package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.ErrorModel;
import com.examplespringboot.demo.Entity.Movie;
import com.examplespringboot.demo.Service.Impl.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("films",filmService.findAll());
        return "admin/film";
    }

    @GetMapping("add")
    public String addFilm(ModelMap modelMap, @ModelAttribute("filmadd") Movie film) {
        modelMap.addAttribute("filmadd",new Movie());
        return "admin/film-add";
    }

    @PostMapping("add")
    public String postFilm(RedirectAttributes redirect, @RequestParam("image")MultipartFile file,
                           @RequestParam("openDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date
            , ModelMap modelMap, @ModelAttribute("filmadd") Movie film, BindingResult result) {

        List<String> arrerror = new ArrayList<>();
        if(film.getName().equals("")){
            String errname = "*Tên không được rỗng";
            arrerror.add(errname);
        }
        if(date == null){
            String errdate = "*Ngày không được rỗng";
            arrerror.add(errdate);
        }
        if(film.getDescription().equals("")){
            String errdes = "*Mô tả không được rỗng";
            arrerror.add(errdes);
        }
        if(arrerror.size() > 0){
            modelMap.addAttribute("errors",arrerror);
            return "admin/film-add";
        }else {
            film.setImage("/upload/" + file.getOriginalFilename());
            film.setOpenDate(date);
            filmService.insert(film);
            redirect.addFlashAttribute("success", "Thêm phim thành công");
            return "redirect:/admin/film";
        }
    }

    @GetMapping("update/{id}")
    public String getPageUpdateFilm(ModelMap modelMap,@PathVariable("id") int id,
                                    @ModelAttribute("filmupdate") Movie film) {
        Movie movie = filmService.findById(id);
        modelMap.addAttribute("filmupdate",movie);
        return "admin/film-edit";
    }

    @PostMapping("update")
    @ResponseBody
    public ResponseEntity<ErrorModel> updateFilm(@Validated @RequestBody Movie film,
                                                 BindingResult error) {
        if(error.hasErrors()){
            ErrorModel errorModel = new ErrorModel(false, "Lỗi không hợp lệ");
            return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.OK);
        }
        filmService.update(film);
        ErrorModel errorModel = new ErrorModel(true, "Valid");
        return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.OK);
    }



}
