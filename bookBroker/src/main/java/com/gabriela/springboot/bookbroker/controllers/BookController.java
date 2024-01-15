package com.gabriela.springboot.bookbroker.controllers;

import com.gabriela.springboot.bookbroker.models.Book;
import com.gabriela.springboot.bookbroker.models.LoginUser;
import com.gabriela.springboot.bookbroker.models.User;
import com.gabriela.springboot.bookbroker.services.BookService;
import com.gabriela.springboot.bookbroker.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BookController {

    @Autowired
    private UserService users;
    @Autowired
    private BookService books;

    @GetMapping("/")
    public String index(Model model) {

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

        return "redirect:/home";
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

        model.addAttribute("books", books.all());
        model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
        return "home.jsp";
    }

    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {

        User user = users.findById((Long)session.getAttribute("userId"));
        model.addAttribute("user", user);

        return "addPage.jsp";
    }

    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "addPage.jsp";
        }

        books.create(book);

        return "redirect:/home";
    }

    @GetMapping("/books/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Book book = books.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));

        return "book.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Book book = books.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));

        return "editPage.jsp";
    }

    @PutMapping("/books/{id}/edit")
    public String updateBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        if(result.hasErrors()) {
            return "editPage.jsp";
        }

        books.update(book);

        return "redirect:/home";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Book book = books.findById(id);
        books.delete(book);

        return "redirect:/home";
    }

    @GetMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Book book = books.findById(id);
        book.setBorrower(users.findById((Long)session.getAttribute("userId")));
        books.update(book);

        return "redirect:/home";
    }

    @GetMapping("/books/{id}/return")
    public String returnBook(@PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Book book = books.findById(id);
        book.setBorrower(null);
        books.update(book);

        return "redirect:/home";
    }

}