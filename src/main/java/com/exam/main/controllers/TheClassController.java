package com.exam.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.exam.main.models.LoginUser;
import com.exam.main.models.TheClass;
import com.exam.main.models.User;
import com.exam.main.services.TheClassService;
import com.exam.main.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TheClassController {

	// Add once service is implemented:
	@Autowired
	private UserService users;
	@Autowired
	private TheClassService theClass;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    		User user = users.register(newUser, result);
    	
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = users.login(newLogin, result);   
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
    
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	model.addAttribute("theClass", theClass.all());
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "home.jsp";
    }
    
    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("theClass") TheClass theClass, Model model, HttpSession session) {
    	
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
    	return "addPage.jsp";
    }
    
    @PostMapping("/theClass")
    public String createTheClass(@Valid @ModelAttribute("theClass") TheClass theClasser, BindingResult result) {

    	if (result.hasErrors()) {
    		return "addPage.jsp";
    	}
    	
    	theClass.create(theClasser);
    	
    	return "redirect:/home";
    }
    
    @GetMapping("/theClass/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("theClass", theClass.findById(id));
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "view.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/theClass/{id}/edit")
    public String editTheClass(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	TheClass theClasser = theClass.findById(id);
    	model.addAttribute("theClass", theClasser);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "editPage.jsp";
    }
    
    @PutMapping("/theClass/{id}/edit")
    public String updateTheClass(Model model, @Valid @ModelAttribute("theClass") TheClass theClasser, BindingResult result, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	if(result.hasErrors()) {
    		return "editPage.jsp";
    	}
    	
    	theClass.update(theClasser);
    	
    	return "redirect:/home";
    }
    
    @GetMapping("/theClass/{id}/delete")
    public String deleteTheClass(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	TheClass theClasser = theClass.findById(id);
    	theClass.delete(theClasser);
    	
    	return "redirect:/home";
    }
    

}