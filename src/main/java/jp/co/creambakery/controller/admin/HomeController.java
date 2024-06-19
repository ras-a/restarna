package jp.co.creambakery.controller.admin;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@Component("adminHome")
@RequestMapping
public class HomeController {
    @GetMapping
    public String adminHome() {
        return "admin/home";
    }
}
