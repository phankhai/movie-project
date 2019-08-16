package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.Room;
import com.examplespringboot.demo.Service.Impl.CinemaService;
import com.examplespringboot.demo.Service.Impl.CineplexService;
import com.examplespringboot.demo.Service.Impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/room")
@SessionAttributes({"pageindex"})
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private CineplexService cineplexService;
    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public String index(HttpSession session, ModelMap modelMap) {
        modelMap.addAttribute("rooms",roomService.findAllByOrderByNameAsc());
        modelMap.addAttribute("pageindex",session.getAttribute("pageindex"));
        return "admin/room";
    }

    @GetMapping("add")
    public String addRoom(Model modelMap, @ModelAttribute("room") Room room){
        modelMap.addAttribute("room",new Room());
        return "admin/room-add";
    }

    @PostMapping("add")
    public String postRoom(ModelMap modelMap, RedirectAttributes redirect,
                           @Validated @ModelAttribute("room") Room room, BindingResult result){
        if(result.hasErrors()){
            return "admin/room-add";
        }
        roomService.insert(room);
        redirect.addFlashAttribute("success", "Thêm phòng thành công");
        return "redirect:/admin/room";
    }

    @GetMapping("update/{idroom}")
    public String updateRoom(ModelMap modelMap,@PathVariable("idroom") int idroom) {
        modelMap.addAttribute("roomupdate",roomService.findById(idroom));
        modelMap.addAttribute("cineplexs",cineplexService.findAll());
        return "admin/room-edit";
    }

    @PostMapping("update")
    public String updateRoomPost(ModelMap modelMap,@ModelAttribute("roomupdate") Room room,
                                 BindingResult result) {
        if(result.hasErrors()){
            modelMap.addAttribute("cineplexs",cineplexService.findAll());
            return "admin/room-edit";
        }
        roomService.update(room);
        return "redirect:/adim/room";
    }

    @GetMapping("pagingApi/{pageIndex}")
    public Object pagingRoom(HttpSession session, @PathVariable("pageIndex") int pageIndex){
        Page<Room> rooms = roomService.findAllPage(pageIndex - 1, 4);
        if(rooms.getSize() == 0) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Object>(rooms, HttpStatus.OK);
    }

    @GetMapping("paging/{pageIndex}")
    public String pagingRoom(ModelMap modelMap,@PathVariable("pageIndex") int pageIndex){
        Page<Room> rooms = roomService.findAllPage(pageIndex - 1, 4);
        if(rooms.getSize() == 0) {
            modelMap.addAttribute("notcontent","không có gì");
        }
        modelMap.addAttribute("roomspaging", rooms);
        modelMap.addAttribute("currentpage",pageIndex);
        return "admin/room";
    }




}
