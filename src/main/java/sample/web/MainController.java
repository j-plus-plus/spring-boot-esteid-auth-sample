package sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping(value = "/")
    @ResponseBody
    public String home(Principal principal) {
        return "Hello, " + principal.getName() + "!";
    }
}
