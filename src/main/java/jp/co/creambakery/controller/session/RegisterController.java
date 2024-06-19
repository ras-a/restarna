package jp.co.creambakery.controller.session;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;
import jp.co.creambakery.bean.*;


/**
 * ユーザ登録するためのコントローラー
 */
@Controller
@RequestMapping("/user")
public class RegisterController 
{

    @Autowired
    private CustomerRepository repository;

    /**
     * 入力画面へ遷移
     * @param form
     * @return "input"
     */
    @GetMapping(path = "/input")
    public String input(@Valid @ModelAttribute RegisterForm form) {
        return "client/input";
    }

    /**
     * データベースに登録し、完了画面へ遷移
     * @param form
     * @param model
     * @return "complete"
     */
    @PostMapping(path = "/register")
    public String register(@Valid @ModelAttribute RegisterForm form, Model model) {
        Customer customer = new Customer();
        customer.setName(form.getName());
        customer.setReading(form.getReading());
        customer.setPassword(form.getPassword());
        customer.setEmail(form.getEmail());
        repository.save(customer);
        BeanFactory factory = new BeanFactory();
        model.addAttribute("customer", factory.createBean(customer));
        return "client/complete";
    }
}
