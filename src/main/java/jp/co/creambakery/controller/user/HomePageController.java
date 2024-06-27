package jp.co.creambakery.controller.user;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.*;


/**
 * HomePageController
 */
@Controller
@RequestMapping("/home")
public class HomePageController
{
	HttpSession session;
	@GetMapping
	public String homePage() {
		return "user/home";
	}
}