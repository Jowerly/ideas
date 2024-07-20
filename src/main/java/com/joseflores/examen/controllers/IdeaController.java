package com.joseflores.examen.controllers;

import java.util.List;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseflores.examen.models.Idea;
import com.joseflores.examen.models.User;
import com.joseflores.examen.services.IdeaService;
import com.joseflores.examen.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class IdeaController {
    @Autowired
    IdeaService ideaService;
    @Autowired
    UserService userService;
    @GetMapping("/ideas")
    public String ideasList(@RequestParam(value = "sort" , required = false) String sort, Model model, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        List<Idea> ideas;
        if ("asc".equals(sort)) {
            ideas = ideaService.findAllByLikesAsc();
        } else if ("decs".equals(sort)) {
            ideas = ideaService.findAllByLikesDesc();
        } else {
            ideas = ideaService.findAll();
        }
        Long userid = (Long) session.getAttribute("userid");
        User user = userService.findUserById(userid);
        model.addAttribute("user", user);
        model.addAttribute("ideas", ideas);
        return "home.jsp";
    }
    @PostMapping("/ideas/{id}/like")
    public String postMethodName(@PathVariable("id")Long id, HttpSession session ) {
        Long userid = (Long) session.getAttribute("userid");
        if (userid == null) {
            return "redirect:/";
        }
        Idea idea = ideaService.findIdeaById(id);
        User user = userService.findUserById(userid);

        if (idea.getUsersWhoLiked().contains(user)) {
            idea.getUsersWhoLiked().remove(user);
            } else {
            idea.getUsersWhoLiked().add(user);
        }
        ideaService.updatedIdea(idea);
        return "redirect:/ideas";
    }
    @PostMapping("/ideas/{id}/unlike")
    public String unlike(@PathVariable("id")Long id, HttpSession session ) {
        Long userid = (Long) session.getAttribute("userid");
        if (userid == null) {
            return "redirect:/";
        }
        Idea idea = ideaService.findIdeaById(id);
        User user = userService.findUserById(userid);
        // if (idea != null && user != null) {
            if (idea.getUsersWhoLiked().contains(user)) {
                idea.getUsersWhoLiked().remove(user);
                ideaService.updatedIdea(idea);
            }
        return "redirect:/ideas" ;
}
    @GetMapping("/ideas/new")
    public String NewIdea(@ModelAttribute("idea") Idea idea, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        return "NewIdea.jsp";
    }
    @PostMapping("/ideas/new")
        public String NewIdea(@Valid @ModelAttribute("idea")Idea idea , HttpSession session, BindingResult result) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
            if (result.hasErrors()) {
            return "NewIdea.jsp";
        }
        Long userid = (Long) session.getAttribute("userid");
        User user = userService.findUserById(userid);
        idea.setCreator(user);
        ideaService.createIdea(idea);
        return "redirect:/ideas";
    }
    @GetMapping("/ideas/{id}")
    public String ideaDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        Idea idea = ideaService.findIdeaById(id);
        if (idea == null) {
            return "redirect:/ideas";
        }
        // Long userid = (Long) session.getAttribute("userid");
        // if (!idea.getCreator().getId().equals(userid)) {
        //     return "redirect:/ideas";
        // }
        Long userid = (Long) session.getAttribute("userid");
        model.addAttribute("idea", idea);
        model.addAttribute("usersWhoLiked", idea.getUsersWhoLiked());
        return "ideasDetails.jsp";
    }
    @GetMapping("/ideas/{id}/edit")
    public String EditeIdea(@PathVariable("id")Long id, Model model, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        Idea idea = ideaService.findIdeaById(id);
        if (idea == null) {
            return "redirect:/ideas";
        }
        Long userid = (Long) session.getAttribute("userid");
        if (!idea.getCreator().getId().equals(userid)) {
            return "redirect:/ideas";
        }
        model.addAttribute("idea", idea);
        model.addAttribute("userid", userid);
        return "ideasEdit.jsp";
    }
    
    @PostMapping("/ideas/{id}/edit")
    public String ideaEdit(@PathVariable("id")Long id, @Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        Long userid = (Long) session.getAttribute("userid");
        Idea exist = ideaService.findIdeaById(id);
        if (!exist.getCreator().getId().equals(userid)) {
            return "redirect:/ideas";
        }
        if (result.hasErrors()) {
            return "ideasEdit.jsp";
        }
        idea.setId(id);
        idea.setCreator(exist.getCreator());
        idea.setUsersWhoLiked(exist.getUsersWhoLiked());

        ideaService.updatedIdea(idea);
        return "redirect:/ideas";
    }
    @PostMapping("/ideas/{id}/delete")
    public String DeleteIdea(@PathVariable("id")Long id, HttpSession session) {
        if (session.getAttribute("userid") == null) {
            return "redirect:/";
        }
        Long userid = (Long) session.getAttribute("userid");
        Idea idea = ideaService.findIdeaById(id);
        if (!idea.getCreator().getId().equals(userid)) {
            return "redirect:/ideas";
        }
        ideaService.DeleteIdea(id);
        return "redirect:/ideas";
    }
    

}
