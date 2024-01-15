package com.gabriela.springboot.displaydate.controllers;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.ui.Model;
        import java.text.SimpleDateFormat;
        import java.util.Date;

@Controller
public class mainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/date")
    public String date(Model model) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        String currentDate = sdfDate.format(new Date());
        model.addAttribute("currentDate", currentDate);
        return "date";
    }

    @RequestMapping("/time")
    public String time(Model model) {
        SimpleDateFormat sdfTime = new SimpleDateFormat("h:mm a");
        String currentTime = sdfTime.format(new Date());
        model.addAttribute("currentTime", currentTime);
        return "time";
    }

}