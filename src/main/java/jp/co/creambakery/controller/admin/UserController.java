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
	CustomerRepository customerRepository;
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
        var entity = customerRepository.findAllNotDeleted();
        var customers = factory.createCustomerList(entity);
        model.addAttribute("customers", customers);
        return "admin/user/list";
    }

    @PostMapping("/delete")
    public String userDelete(Integer id)
    {
        Customer customer  = customerRepository.getReferenceById(id);
        customer.setDeleted(1);
        customerRepository.save(customer);
        return "admin/user/complete";
    }

    @PostMapping("/review/delete")
    public String userReviewDelete(Integer posterId, Integer itemId)
    {
        Customer poster = customerRepository.getReferenceById(posterId);
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
        var customerEntity = customerRepository.getReferenceById(id);
        var customer = factory.createBean(customerEntity);
        var reviewEntity = reviewRepository.findByPosterNotDeleted(customerEntity);
        var reviews = factory.createReviewList(reviewEntity);
        model.addAttribute("customer", customer);
        model.addAttribute("reviews", reviews);
		return "admin/user/detail";
	}

}
