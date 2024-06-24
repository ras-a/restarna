package jp.co.creambakery.controller.item;

import org.springframework.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;
import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;

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

	@GetMapping("/list")
	public String order(HttpSession session, Model model)
	{
		var orders = orderRepository.findAllByUser(getUser(session));

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
	public String complete(HttpSession session, @Valid OrderForm form, BindingResult result, Model model)
	{
		if (result.hasErrors())
			;
			
		var factory = new BeanFactory();
		var user = getUser(session);
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
	
	@GetMapping("/form")
	public String getMethodName(HttpSession session, @ModelAttribute("form") OrderForm form, Model model) {
		{
		var factory = new BeanFactory();
		session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
		}
		var factory = new BeanFactory();
		var bean = getUser(session);
		var user = userRepository.getReferenceById(bean.getId());
		user = userRepository.save(user);
	
		Integer totalPrice = 0;
		for (var item : factory.createBean(user).getCart()) {
			totalPrice = totalPrice + item.getItem().getPrice() * item.getQuantity();
		}
	
		session.setAttribute("user", factory.createBean(user));
		model.addAttribute("totalPrice", totalPrice);

		return "order/form";
	}
    
	private User getUser(HttpSession session)
	{
		var user = (UserBean) session.getAttribute("user");
	
		if (user == null)
			throw new IllegalStateException("ログインされていない");
	
		return userRepository.getReferenceById(user.getId());
	}
}


