package com.tekup.gestion.controller;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tekup.gestion.models.User;
import com.tekup.gestion.repository.UserRepository;

import ch.qos.logback.core.model.Model;

@Controller
public class ParentController {

    @Autowired
    private UserRepository userRepository;

    // for testing purpose
    @GetMapping("/")
    public String show() {
        return "home";
    }

    // handler for showing the registration page
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registrationPage";
    }
    //Handler for showing the login page
    @GetMapping("/loginPage")
    public String loginPage(@ModelAttribute("user") User user) {
        return "loginPage";
    }
    //Handler for registration process
    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute("user") User user) {
        System.out.println(user);
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return "Data saved Successfully!!";
    }
    @GetMapping("/bien-list")
    public String bienList(Model model) {
        return "bien-list";
    }
    //Handler for Login process
    @PostMapping("/login")
public String loginProcess(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           RedirectAttributes redirectAttributes) {
    User dbuser = userRepository.findByEmail(email);
    Boolean isPasswordMatch = BCrypt.checkpw(password, dbuser.getPassword());

    if (isPasswordMatch) {
        // Redirect to "bien-list.html"
        redirectAttributes.addFlashAttribute("user", dbuser);
        return "redirect:/bien-list";
    } else {
        // Failed login
        return "failed to login";
    }
}
}