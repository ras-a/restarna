package jp.co.creambakery.controller.item;

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
	public String order(HttpSession session, Model model)
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

	@PostMapping("/complete")
	public String complete(HttpSession session, @Valid @ModelAttribute("form") OrderForm form, BindingResult result, Model model)
	{
		if (result.hasErrors())
			return "order/form";
			
		var factory = new BeanFactory();
		var user = getUser();
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

		for (var cartItem: user.getCart())
		{
			var entry = new ProductOrderItem(order, cartItem);
			order.getItems().add(entry);
		}

		order = orderRepository.save(order);

		user.getCart().clear();
		System.out.println(user.getCart());
		user = userRepository.save(user);
		System.out.println(user.getCart());

		model.addAttribute("order", factory.createBean(order));
		session.setAttribute("user", factory.createBean(user));

		return "order/complete";
	}
	
	@GetMapping("/form")
	public String getMethodName(@ModelAttribute("form") OrderForm form, Model model) {
		var user = getUser();

		form.setAddress(user.getMainAddress());
		form.setCreditCard(user.getMainCreditCard());

		return "order/form";
	}
    
	private User getUser()
	{
		var user = (UserBean) session.getAttribute("user");
	
		if (user == null)
			throw new IllegalStateException("ログインされていない");
	
		return userRepository.getReferenceById(user.getId());
	}
}


