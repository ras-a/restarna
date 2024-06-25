package jp.co.creambakery.controller.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.creambakery.bean.BeanFactory;
import jp.co.creambakery.entity.User;
import jp.co.creambakery.form.RegisterForm;
import jp.co.creambakery.repository.UserRepository;


/**
 * ユーザ登録するためのコントローラー
 */
@Controller
@RequestMapping("/register")
public class RegisterController 
{

    @Autowired
    private UserRepository repository;
    @Autowired
	HttpSession session;

    /**
     * 入力画面へ遷移
     * @param form
     * @return "input"
     */
    @GetMapping("/input")
    public String input(@Valid @ModelAttribute RegisterForm form) {
        return "user/register/input";
    }

    /**
     * データベースに登録し、完了画面へ遷移
     * @param form
     * @param model
     * @return "complete"
     */
    @PostMapping("/complete")
    public String register(@Valid @ModelAttribute RegisterForm form, Model model) {
        User user = new User();
        user.setName(form.getName());
        user.setReading(form.getReading());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setDateCreated(new Date());
        user.setDeleted(0);
        repository.save(user);
        BeanFactory factory = new BeanFactory();
        session.setAttribute("user", factory.createBean(user));
        model.addAttribute("user", factory.createBean(user));
        return "user/register/complete";
    }
}
