package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.Cinema;
import com.examplespringboot.demo.Service.Impl.CinemaService;
import com.examplespringboot.demo.Service.Impl.CineplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/cinemas")
public class CinemasController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CineplexService cineplexService;

    @GetMapping()
    public String index(ModelMap modelMap){
        modelMap.addAttribute("cinemas",cinemaService.findAll());
        return "admin/cinema";
    }

    @GetMapping("paging/{pageIndex}/{pageSize}")
    public Object paging(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Cinema> cinemas = cinemaService.findAllPaging(pageIndex - 1, pageSize);
        if(cinemas.getSize() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Cinema>>(cinemas,HttpStatus.OK);
    }

    @GetMapping("add")
    public String addCinema(ModelMap modelMap, @ModelAttribute("cinema") Cinema cinema) {
        modelMap.addAttribute("cinema", new Cinema());
        modelMap.addAttribute("cineplexs",cineplexService.findAll());
        return "admin/cinema-add";
    }

    @PostMapping("add")
    public String postCinema(@RequestParam("image") MultipartFile file, ModelMap modelMap,
                             RedirectAttributes redirectAttributes,
                             @ModelAttribute("cinema") Cinema cinema, BindingResult result) {
        List<String> cinemaValidate = CinemasController.validateFormCinema(cinema, file);
        if(cinemaValidate.size() == 0){
            cinema.setImage("/upload/"+file.getOriginalFilename());
            cinemaService.insert(cinema);
            redirectAttributes.addFlashAttribute("success","thêm thành công");
            return "redirect:/admin/cinemas";
        }else {
            modelMap.addAttribute("errors",cinemaValidate);
            modelMap.addAttribute("cineplexs",cineplexService.findAll());
            return "admin/cinema-add";
        }
    }

    public static List<String> validateFormCinema(Cinema cinema, MultipartFile file) {
        List<String> listvalidate = new ArrayList<>();
        if(cinema.getName().equals("") || cinema.getName() == null){
            listvalidate.add("*Tên Không Rỗng");
        }
        if(cinema.getDescription().equals("") || cinema.getDescription() == null){
            listvalidate.add("*Mô Tả Không Rỗng");
        }
        if(cinema.getAddress().equals("") || cinema.getAddress() == null){
            listvalidate.add("*Địa Chỉ Không Rỗng");
        }
        if(cinema.getPhone().length() < 10){
            listvalidate.add("*Số Điện Thoại Không Hợp Lệ");
        }
        if(file.getSize() == 0){
            listvalidate.add("*Chọn Hình");
        }
        return listvalidate;
    }

    @GetMapping("update/{idcinema}")
    public String cinemaUpdate(ModelMap modelMap, @PathVariable("idcinema") int id, RedirectAttributes redirect,
                               @ModelAttribute("cinemaupdate") Cinema cinema, HttpSession session){
        modelMap.addAttribute("cinemaupdate",cinemaService.findById(id));
        modelMap.addAttribute("cineplexs",cineplexService.findAll());
        Cinema cinemaupdate = cinemaService.findById(id);
        session.setAttribute("img", cinemaupdate.getImage());
        return "admin/cinema-edit";
    }

    @PostMapping("update")
    public String cinemaPostUpdate(ModelMap modelMap, @RequestParam("image") MultipartFile file,HttpSession session,
                                   RedirectAttributes redirect, @ModelAttribute("cinemaupdate") Cinema cinema
            , BindingResult result) {
//        if(result.hasErrors()){
//            modelMap.addAttribute("cineplexs",cineplexService.findAll());
//            return "admin/cinema-edit";
//        }
        if(file.getSize() > 0) {
            cinema.setImage("/upload/" + file.getOriginalFilename());
            redirect.addFlashAttribute("success","cập nhật thành công");
        }else {
            String img = (String) session.getAttribute("img");
            cinema.setImage(img);
        }
        cinemaService.update(cinema);
        session.removeAttribute("img");
        return "redirect:/admin/cinemas";
    }




}
