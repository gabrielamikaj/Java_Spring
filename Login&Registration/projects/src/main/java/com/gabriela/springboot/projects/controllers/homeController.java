package com.gabriela.springboot.projects.controllers;


import com.gabriela.springboot.projects.models.LoginUser;
import com.gabriela.springboot.projects.models.User;
import com.gabriela.springboot.projects.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homeController {
    @Autowired
    private UserService userServ;



    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser,
                        @ModelAttribute("newLogin") User newLogin, HttpSession session) {
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID != null) {

            return "redirect:/dashboard";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
                           HttpSession session) {

        userServ.register(newUser, result);

        if (result.hasErrors()) {


            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("loggedInUserID", newUser.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
                        HttpSession session) {

        User user = userServ.login(newLogin, result);



        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }


        session.setAttribute("loggedInUserID", user.getId());
        return "redirect:/dashboard";
    }
    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID == null) {

            return "redirect:/";
        }

        User loggedInUser = userServ.findOneUser(loggedInUserID);

        model.addAttribute("user", loggedInUser);

        return "dashboard.jsp";

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}