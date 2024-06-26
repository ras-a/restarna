package jp.co.creambakery.controller.admin;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

@Controller
@Component("adminlogin")
@RequestMapping("/login")
public class LoginController 
{

	@Autowired
	private AdminRepository repository;
	@Autowired
	HttpSession session;

	@GetMapping
	public String adminLogin(@ModelAttribute("form") AdminLoginForm form, Model model) 
	{
		session.invalidate();
		return "admin/login";
	}

	@PostMapping
	public String adminLogin(@Valid @ModelAttribute("form") AdminLoginForm form,
							BindingResult result, HttpSession session, Model model) 
	{
		var factory = new BeanFactory();

		if(result.hasErrors()) 
		{
			return "admin/login";
		}
		String name = form.getName();
		String password = form.getPassword();

		Admin admin = repository.findByNameAndPassword(name, password);
		if (admin != null) 
		{
			session.setAttribute("admin", factory.createBean(admin));
			return "redirect:/admin/";
		}else
		{
			model.addAttribute("errMessage", "名前、またはパスワードが間違っています。");
			return "admin/login";
		}   
	}

	@RequestMapping("/logout")
	public String logout()
	{
		session.invalidate();
		return "redirect:/admin/login";
	}
}
