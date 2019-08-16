package com.examplespringboot.demo.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public String index() {
        return "redirect:/admin/user";
    }

    @GetMapping("auth/login")
    public String errorLogin(@RequestParam(required = false)String error, ModelMap modelMap) {
        if(error != null){
            modelMap.addAttribute("errorlogin","Login Fail");
            return "admin/login-admin";
        }
        return "admin/login-admin";
    }

    @GetMapping("admin/403")
    public String error403() {
        return "admin/error/403";
    }

}
