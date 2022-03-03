package es.dws.exercise2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnlaceController {

    @GetMapping("/enlace")
    public String enlace(Model model, @RequestParam String num) {
        model.addAttribute("num", num);
        return "enlace";
    }


    @GetMapping("/enlace/{num}")
    public String enlace2(Model model, @PathVariable String num) {
        model.addAttribute("num", num);
        return "enlace";
    }
}
