package jp.co.creambakery.controller.user.info;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;


@Controller
@RequestMapping("/credit_card")
public class CreditCardController {

	@Autowired
	UserRepository repository;
	@Autowired
	HttpSession session;

	private User getUser()
	{
		var bean = (UserBean)session.getAttribute("user");
		return repository.getReferenceById(bean.getId());
	}

	@GetMapping("/address")
	public String listAddresses() {
		return "user/address/list";
	}
	
	@GetMapping("/address/add")
	public String addAddress(@ModelAttribute("form") AddressForm form) {
		return "user/address/add";
	}
	
	@PostMapping("/address/add")
	public String addAddress(@Valid @ModelAttribute("form") AddressForm form, BindingResult result) {
		if (result.hasErrors())
			return "user/address/add";
		
		var factory = new BeanFactory();
		
		var user = getUser();
		user.getAddresses().add(new AddressProfile(user, form));
		user = repository.save(user);

		session.setAttribute("user", factory.createBean(user));

		return "user/address/list";
	}
}
