package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.User;
import com.examplespringboot.demo.Service.Impl.RoleService;
import com.examplespringboot.demo.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String user(Model modelMap, Principal principal){
//        String name = principal.getName();
//        System.out.println(name);
        modelMap.addAttribute("users",userService.findAll());
        return "admin/user";
    }

    @GetMapping("add")
    public String useradd(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("roles",roleService.findAll());
        return "admin/user-add";
    }

    @PostMapping("add")
    public String userAdd(RedirectAttributes redirect, ModelMap modelMap,
                          @Validated @ModelAttribute("user") User user, BindingResult error) {
        if(error.hasErrors()){
            modelMap.addAttribute("roles",roleService.findAll());
            return "admin/user-add";
        }
        userService.insert(user);
        redirect.addFlashAttribute("success", "Thêm người dùng thành công");
        return "redirect:/admin/user";
    }

    @GetMapping("update/{iduser}")
    public String userUpdate(@PathVariable("iduser")String iduser, ModelMap modelMap,
                             @ModelAttribute("userupdate") User user){
        modelMap.addAttribute("userupdate",userService.findById(iduser));
        modelMap.addAttribute("roles",roleService.findAll());
        return "admin/user-edit";
    }

    @PostMapping("update")
    public String postUpdateUser(ModelMap modelMap, @Validated @ModelAttribute("userupdate") User user
            , BindingResult result) {
        if(result.hasErrors()){
            modelMap.addAttribute("roles",roleService.findAll());
            return "admin/user-edit";
        }
        userService.update(user);
        return "redirect:/admin/user";
    }



}
