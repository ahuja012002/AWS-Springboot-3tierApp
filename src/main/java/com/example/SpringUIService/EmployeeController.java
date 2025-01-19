package com.example.SpringUIService;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 

 
@Controller
public class EmployeeController {
 
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
 
    @GetMapping("/home")
    public String viewHomePage(OAuth2AuthenticationToken token, Model model) {
        model.addAttribute("allemplist", employeeServiceImpl.getEmployeeData());
        model.addAttribute("login",token.getPrincipal().getAttribute("login"));
        return "home";
    }
    
    @GetMapping("/login")
    public String viewHomePage() {
        return "custom_login";
    }
    
 
   
    @GetMapping("/addnew")
    public String addNewEmployee(OAuth2AuthenticationToken token,Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("login",token.getPrincipal().getAttribute("login"));
        return "newemployee";
    }
 
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeServiceImpl.updateEmployeeData(employee);
        return "redirect:/home";
    }
    
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeServiceImpl.saveEmployeeData(employee);
        return "redirect:/home";
    }
 
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model,OAuth2AuthenticationToken token) {
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("login",token.getPrincipal().getAttribute("login"));
        return "update";
    }
 
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        employeeServiceImpl.deleteEmployeeData(id);
        return "redirect:/home";
 
    }
}