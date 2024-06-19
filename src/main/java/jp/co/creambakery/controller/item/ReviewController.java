package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.entity.keys.*;
import jp.co.creambakery.repository.*;


@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	HttpSession session;

	@GetMapping("/from/{userId}/{itemId}")
	public String details(@PathVariable Integer userId, @PathVariable Integer itemId, Model model) {
		var factory = new BeanFactory();
		var user = customerRepository.getReferenceById(userId);
		for (var entity: user.getReviews())
		{
			if (entity.getItem().getId() == itemId)
			{
				model.addAttribute("review", factory.createBean(entity));
			}
		}

		return "item/review/details";
	}

	@GetMapping("/from/{userId}")
	public String byUser(@PathVariable Integer userId, Model model) {
		var factory = new BeanFactory();
		var entity = customerRepository.getReferenceById(userId);

		model.addAttribute("poster", factory.createBean(entity));

		return "item/review/list/by_user";
	}

	@GetMapping("/{itemId}")
	public String byItem(@PathVariable Integer itemId, Model model)
	{
		var factory = new BeanFactory();
		var item = itemRepository.getReferenceById(itemId);
		model.addAttribute("item", factory.createBean(item));
		return "item/review/list/by_item";
	}

	@GetMapping("/own/{itemId}")
	public String details (@PathVariable Integer itemId, Model model)
	{
		var user = (CustomerBean) session.getAttribute("user");
		return details(user.getId(), itemId, model);
	}

	@GetMapping("/own")
	public String details (Model model)
	{
		var user = (CustomerBean) session.getAttribute("user");
		return byUser(user.getId(), model);
	}

	@PostMapping("/add/{itemId}")
	public String add(@PathVariable Integer itemId, Integer score, String description, Model model) {
		var userBean = (CustomerBean)session.getAttribute("user");

		
		var poster = customerRepository.getReferenceById(userBean.getId());
		var item = itemRepository.getReferenceById(itemId);
		// var alr = reviewRepository.getReferenceById(new ReviewKey(poster, item));
		// if (alr != null)
		// {
		// 	model.addAttribute("errMsg", "この商品のレビューにはもう既に口コミを投稿されています。");
		// 	return "/item/%d".formatted(item.getId());
		// }
			
		var review = new Review();
		review.setItem(item);
		review.setPoster(poster);
		review.setScore(score);
		review.setDescription(description);


		reviewRepository.save(review);



		return "redirect:/item/review/own/%d".formatted(item.getId(), itemId);
	}

	@PostMapping("/edit/{itemId}")
	public String edit(@PathVariable Integer itemId, Integer score, String description, Model model) {
		var userBean = (CustomerBean)session.getAttribute("user");

		var poster = customerRepository.getReferenceById(userBean.getId());
		var item = itemRepository.getReferenceById(itemId);

		var review = reviewRepository.getReferenceById(new ReviewKey(poster, item));
		
		if (score != null)
		{
			review.setScore(score);
		}
		if (description != null)
		{
			review.setDescription(description);
		}

		reviewRepository.save(review);

		return "redirect:/item/review/%d/%d".formatted(poster.getId(), itemId);
	}

}
