package com.gabriela.springboot.admindashboard.controller;
import java.security.Principal;
import java.util.Date;
import com.gabriela.springboot.admindashboard.models.User;
import com.gabriela.springboot.admindashboard.services.UserService;
import com.gabriela.springboot.admindashboard.validator.UserValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private UserService userService;
    private UserValidator userValidator;

    public MainController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/register")
    public String registration(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model,
            HttpSession session,
            HttpServletRequest request) {
        userValidator.validate(user, result);
        String password = user.getPassword();
        if(result.hasErrors()) {
            return "loginPage.jsp";
        }
        if(userService.allUsers().size()==0) {
            userService.newUser(user, "ROLE_SUPER_ADMIN");
        }else {
            userService.newUser(user, "ROLE_USER");
        }

        authWithHttpServletRequest(request, user.getEmail(), password);
        return "redirect:/";
    }
    public void authWithHttpServletRequest(HttpServletRequest request, String email, String password) {
        try {
            request.login(email, password);
        } catch (ServletException e) {
            System.out.println("Error while login: " + e);
        }
    }

    @RequestMapping("/admin/{id}")
    public String makeAdmin(Principal principal, @PathVariable("id") Long id, Model model) {
        if(principal==null) {
            return "redirect:/login";
        }

        User user = userService.findById(id);
        userService.upgradeUser(user);

        model.addAttribute("users", userService.allUsers());

        return "redirect:/home";
    }

    @RequestMapping("/login")
    public String login(
            @ModelAttribute("user") User user,
            @RequestParam(value="error", required=false) String error,
            @RequestParam(value="logout", required=false) String logout,
            Model model) {

        if(error!=null) {
            model.addAttribute("errorMessage","Invalid Credentials, Please try again.");
        }
        if(logout!=null) {
            model.addAttribute("logoutMessage","Logout Successful!");
        }

        return "loginPage.jsp";
    }

    @RequestMapping(value={"/", "/home"})
    public String home(Principal principal, Model model) {
        if(principal==null) {
            return "redirect:/login";
        }
        String email = principal.getName();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);

        if(user!=null) {
            user.setLastLogin(new Date());
            userService.updateUser(user);
            if(user.getRoles().get(0).getName().contains("ROLE_SUPER_ADMIN")||user.getRoles().get(0).getName().contains("ROLE_ADMIN")) {
                model.addAttribute("currentUser", userService.findByEmail(email));
                model.addAttribute("users", userService.allUsers());
                return "adminPage.jsp";
            }
        }

        return "home.jsp";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(Principal principal, @PathVariable("id") Long id, HttpSession session, Model model) {
        if(principal==null) {
            return "redirect:/login";
        }
        User user = userService.findById(id);
        userService.deleteUser(user);

        model.addAttribute("users", userService.allUsers());

        return "redirect:/home";
    }

}