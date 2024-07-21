package com.joseflores.examen.controllers;

import org.apache.tomcat.util.openssl.pem_password_cb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseflores.examen.models.User;
import com.joseflores.examen.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class UserController {
    @Autowired
        public UserService userService;
    
    @GetMapping("")
    public String loginyRegistro(Model model) {
        model.addAttribute("user", new User());
        return "login.jsp";
    }
    @PostMapping("/user/new")
    public String registro(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model){
        if (result.hasErrors()) {
            return "login.jsp";
        }
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            result.rejectValue("passwordConfirmation", "error.user", "Passwords must match");
                return "login.jsp";
        }
        User userEntity  = userService.registerUser(user);
        session.setAttribute("userid", userEntity.getId());
        return "redirect:/ideas";
    }
    @PostMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User user = userService.findByEmail(email);
            session.setAttribute("userid", user.getId());
            return "redirect:/ideas";
        } else {
            model.addAttribute("error", "Email o la Contraseña invalidos");
            model.addAttribute("user", new User());
            return "login.jsp";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
}
