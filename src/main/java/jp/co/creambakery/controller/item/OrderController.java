package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
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
	HttpSession session;

	@GetMapping("/list")
	public String order(Model model)
	{
		var user = new User();
		user.setId(getUser().getId());
		var orders = orderRepository.findAllByUser(user);

		model.addAttribute("orders", orders);
		return "order/list";
	}

	@GetMapping("/{orderId}")
	public String details()
	{
		return "order/details";
	}

	@PostMapping("/confirm")
	public String confirm()
	{
		var user = getUser();


		return "order/details";
	}

	private UserBean getUser()
	{
		var user = (UserBean) session.getAttribute("user");

		if (user == null)
			throw new IllegalStateException("ログインされていない");

		return user;
	}
}

