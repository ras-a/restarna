package jp.co.creambakery.controller.user;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;



/**
 * HomePageController
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController
{
	@GetMapping
	public String homePage() {
		return "user/homepage";
	}
	
	
}