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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
	public String getMethodName(@ModelAttribute("form") OrderForm form) {
		return "order/form";
	}
	

	@PostMapping("/complete")
	public String complete(@Valid OrderForm form, BindingResult result, Model model)
	{
		if (result.hasErrors())
			;
		
		var factory = new BeanFactory();
		var user = getUser();
		var order = new ProductOrder(user, form);

		if (form.getPaymentMethod() == 0)
		{
			for (var card: user.getCreditCards())
			{
				if (card.getId() == form.getCreditCard())
					order.setCreditCard(card);
			}
			if (order.getCreditCard() == null)
				throw new IllegalStateException("クレジットカードが存在しない");
		}
		
		for (var address: user.getAddresses())
		{
			if (address.getId() == form.getAddress())
				order.setAddress(address);
		}
		if (order.getAddress() == null)
			throw new IllegalStateException("住所プロフィールが存在しない");

		for (var cartItem: user.getCart())
		{
			var entry = new ProductOrderItem(order, cartItem);
			order.getItems().add(entry);
		}

		order = orderRepository.save(order);

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

