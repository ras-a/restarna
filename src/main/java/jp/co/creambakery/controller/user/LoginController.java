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
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private CustomerRepository repository;
	@Autowired
	HttpSession session;

	@GetMapping
	public String userLogin(@ModelAttribute("form") UserLoginForm form, Model model)
	{
		session.invalidate();
		model.addAttribute("form", form);
		return "client/login";
	}

	@PostMapping
	public String userLogin(@Valid @ModelAttribute("form") UserLoginForm form,
							BindingResult result, Model model) 
	{
		var factory = new BeanFactory();
		if(result.hasErrors()) 
		{
			return "client/login";
		}

		var customer = repository.findByEmailAndPassword(form.getEmail(), form.getPassword());

		if (customer != null)
		{
			session.setAttribute("user", factory.createBean(customer));
			return "redirect:/session/home";
		} else
		{
			model.addAttribute("errMessage", "メールアドレス、またはパスワードが間違っています。");
			return "client/login";
		}
	}
}
