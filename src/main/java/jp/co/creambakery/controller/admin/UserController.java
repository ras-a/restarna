package jp.co.creambakery.controller.admin;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;

@Controller
@Component("adminUser")
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	HttpSession session;

	@GetMapping("/list")
	public String userList(Model model)
	{
		BeanFactory factory = new BeanFactory();
		var entity = userRepository.findAllNotDeleted();
		var users = factory.createUserList(entity);
		model.addAttribute("users", users);
		return "admin/user/list";
	}

	@PostMapping("/delete")
	public String userDelete(Integer id)
	{
		User user  = userRepository.getReferenceById(id);
		user.setDeleted(1);
		userRepository.save(user);
		return "admin/user/complete";
	}

	@PostMapping("/review/delete")
	public String userReviewDelete(Integer posterId, Integer itemId)
	{
		User poster = userRepository.getReferenceById(posterId);
		Item item = itemRepository.getReferenceById(itemId);
		Review review  = reviewRepository.findByPosterAndItem(poster, item);
		review.setDeleted(1);
		reviewRepository.save(review);
		return "admin/user/complete";
	}

	@GetMapping("/{id}")
	public String userDetail(@PathVariable Integer id, Model model)
	{
		BeanFactory factory = new BeanFactory();
		var userEntity = userRepository.getReferenceById(id);
		var user = factory.createBean(userEntity);
		var reviewEntity = reviewRepository.findByPosterNotDeleted(userEntity);
		var reviews = factory.createReviewList(reviewEntity);
		model.addAttribute("user", user);
		model.addAttribute("reviews", reviews);
		return "admin/user/detail";
	}

}
