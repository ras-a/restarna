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
	
	@GetMapping
	public String listCards() {
		return "user/credit_card/list";
	}

	private User getUser()
	{
		var bean = (UserBean)session.getAttribute("user");
		return repository.getReferenceById(bean.getId());
	}

	@GetMapping("/add")
	public String addCard(@ModelAttribute("form") CreditCardForm form) {
		return "user/credit_card/add";
	}

	@PostMapping("/add")
	public String addCard(@Valid @ModelAttribute("form") CreditCardForm form,
	                      BindingResult result) {
		if (result.hasErrors())
			return "user/credit_card/add";
		
		var factory = new BeanFactory();

		var user = getUser();

		user.getCreditCards().add(new CreditCard(user, form));
		user = repository.save(user);

		var bean = factory.createBean(user);

		session.setAttribute("user", bean);

		return "user/credit_card/list";
	}
	
	@GetMapping("/edit/{cardId}")
	public String getMethodName(@ModelAttribute("form") CreditCardForm form,
	                            @PathVariable Integer cardId) {
		var user = (UserBean)session.getAttribute("user");

		form.populateWith(user.getCreditCard(cardId));

		return "user/credit_card/edit";
	}
	
	@PostMapping("/edit/{cardId}")
	public String edit(@Valid @ModelAttribute("form") CreditCardForm form,
	                            BindingResult result, @PathVariable Integer cardId) {
		var user = getUser();

		var card = user.getCreditCard(cardId);

		form.populate(card);
		
		repository.save(user);
		
		return "user/address/edit/complete";
	}
}
