package jp.co.creambakery.controller.item;

import jakarta.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

/**
 *注文情報入力＆完了コントローラー 
 */
@Controller
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	HttpSession session;

	@GetMapping("/list")
	public String order(Model model)
	{
		var orders = orderRepository.findAllByUser(getUser());

		model.addAttribute("orders", orders);
		return "order/list";
	}

	@GetMapping("/{orderId}")
	public String details(@PathVariable Integer orderId, Model model)
	{
		var factory = new BeanFactory();
		var entity = orderRepository.getReferenceById(orderId);
		model.addAttribute("order", factory.createBean(entity));
		return "order/details";
	}

	@GetMapping("/form")
	public String form(@ModelAttribute("form") OrderForm form, Model model) {
		var user = getUser();
		var factory = new BeanFactory();

		model.addAttribute("creditCards", factory.createCreditCardList(user.getCreditCards()));
		model.addAttribute("addresses", factory.createAddressList(user.getAddresses()));
		form.setAddress(user.getMainAddress());
		form.setCreditCard(user.getMainCreditCard());

		return "order/form";
	}

	@PostMapping("/complete")
	public String complete(@ModelAttribute("form") OrderForm form, BindingResult result, Model model)
	{
		var user = getUser();
		// if (result.hasErrors())
		// {
		// 	model.addAttribute("creditCards", user.getCreditCards());
		// 	model.addAttribute("addresses", user.getAddresses());
		// 	return "order/form";
		// }

		var factory = new BeanFactory();
		var order = new ProductOrder(user, form);

		if (form.getPaymentMethod() == 0)
		{
			var card = form.getCreditCard();
			if (user.getCreditCard(card.getId()) == null)
				throw new IllegalStateException("クレジットカードが存在しない");
			
			order.setCreditCard(card);
		}
		
		var address = form.getAddress();
		if (user.getAddress(address.getId()) == null)
			throw new IllegalStateException("住所プロフィールが存在しない");

		order.setAddress(address);

		order.setItems(user.getCart().stream().map(ci -> new ProductOrderItem(order, ci)).toList());

		orderRepository.save(order);

		user.getOrders().add(order);

		user.getCart().clear();
		user = userRepository.save(user);

		model.addAttribute("order", factory.createBean(order));
		session.setAttribute("user", factory.createBean(user));

		return "order/complete";
	}

	private User getUser()
	{
		var user = (UserBean) session.getAttribute("user");
	
		if (user == null)
			throw new IllegalStateException("ログインされていない");
	
		return userRepository.getReferenceById(user.getId());
	}
}


