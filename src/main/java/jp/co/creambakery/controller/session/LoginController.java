package jp.co.creambakery.controller.session;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

@Controller
@Component("Userlogin")
@RequestMapping("/login")
public class LoginController
{
    @Autowired
	private CustomerRepository repository;
    @Autowired
    HttpSession session;

    @GetMapping
    public String userLogin(@ModelAttribute UserLoginForm form, Model model)
    {
        session.invalidate();
        model.addAttribute("form", form);
        return "client/login";
    }

    @PostMapping
    public String userLogin(@Valid @ModelAttribute UserLoginForm form,
                            BindingResult result, Model model) 
    {
        if(result.hasErrors()) 
        {
            model.addAttribute("form", form);
            model.addAttribute("errMessage", "メールアドレス、またはパスワードが間違っています。");
            return "client/login";
        }
        String email = form.getEmail();
        String password = form.getPassword();
        Customer customer = repository.findByEmailAndPassword(email, password);
        
        if (customer != null)
        {
            session.setAttribute("id", customer.getId());
            session.setAttribute("name", customer.getName());
            session.setAttribute("email", customer.getEmail());
            return "redirect:/session/home";
        }else
        {
            model.addAttribute("errMessage", "メールアドレス、またはパスワードが間違っています。");
            return "client/login";
        }
    }
}
