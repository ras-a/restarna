package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

@Controller
@Component("Userlogin")
public class LoginController
{
	@Autowired
	private UserRepository repository;
	@Autowired
	HttpSession session;

	@GetMapping("/login")
	public String login(@ModelAttribute("form") UserLoginForm form, Model model)
	{
		session.invalidate();
		model.addAttribute("form", form);
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("form") UserLoginForm form,
							BindingResult result, Model model) 
	{
		var factory = new BeanFactory();
		if(result.hasErrors()) 
		{
			return "user/login";
		}

		var user = repository.findByEmailAndPassword(form.getEmail(), form.getPassword());

		if (user != null)
		{
			session.setAttribute("user", factory.createBean(user));
			return "redirect:/user/home";
		} else
		{
			model.addAttribute("errMessage", "メールアドレス、またはパスワードが間違っています。");
			return "user/login";
		}
	}

	@RequestMapping("/logout")
	public String logout()
	{
		session.invalidate();
		return "redirect:/user/login";
	}
}
