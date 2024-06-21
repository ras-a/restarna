package jp.co.creambakery.controller.user.info;

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
@RequestMapping("/address")
public class AddressController {

	@Autowired
	UserRepository repository;
	@Autowired
	HttpSession session;

	private User getUser()
	{
		var bean = (UserBean)session.getAttribute("user");
		return repository.getReferenceById(bean.getId());
	}

	@GetMapping
	public String listAddresses() {
		return "user/address/list";
	}
	
	@GetMapping("/add")
	public String addAddress(@ModelAttribute("form") AddressForm form) {
		return "user/address/add";
	}
	
	@PostMapping("/add")
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

	@GetMapping("/edit/{addressId}")
	public String edit(@ModelAttribute("form") AddressForm form,
	                            @PathVariable Integer addressId)
	{
		var user = (UserBean)session.getAttribute("user");

		form.populateWith(user.getAddress(addressId));
		return "user/address/edit";
	}
	
	@PostMapping("/edit/{addressId}")
	public String edit(@Valid @ModelAttribute("form") AddressForm form, BindingResult result,
	                   Model model, @PathVariable Integer addressId) {
		var user = getUser();
		var factory = new BeanFactory();
		var address = user.getAddress(addressId);

		form.populate(address);
		
		user = repository.save(user);
		
		session.setAttribute("user", factory.createBean(user));

		model.addAttribute("address", factory.createBean(user.getAddress(addressId)));

		return "user/address/details";
	}
}
