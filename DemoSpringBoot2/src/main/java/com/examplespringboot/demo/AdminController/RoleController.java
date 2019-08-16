package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.Role;
import com.examplespringboot.demo.Service.Impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String user(ModelMap modelMap){
        modelMap.addAttribute("roles",roleService.findAll());
        return "admin/role";
    }

    @GetMapping("add")
    public String useradd(@ModelAttribute("role") Role role, ModelMap modelMap){
        modelMap.addAttribute("role",new Role());
        return "admin/role-add";
    }

    @PostMapping("add")
    public String postRole(@Validated @ModelAttribute("role") Role role, BindingResult result) {
        if(result.hasErrors()){
            return "admin/role-add";
        }
        roleService.insert(role);
        return "redirect:/admin/role";
    }

    @GetMapping("update/{idrole}")
    public String editRole(@PathVariable("idrole") String idrole,
                           @ModelAttribute("roleupdate") Role role, ModelMap modelMap){
        modelMap.addAttribute("roleupdate",roleService.findRoleById(idrole));
        return "admin/role-edit";
    }

    @PostMapping("update")
    public String postRoleEdit(@Validated @ModelAttribute("roleupdate") Role role
            , BindingResult result) {
        if(result.hasErrors()){
            return "admin/role-edit";
        }
        roleService.update(role);
        return "redirect:/admin/role";
    }






}
