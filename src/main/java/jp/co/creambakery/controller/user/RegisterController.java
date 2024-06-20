package jp.co.creambakery.controller.user;

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
    private UserRepository repository;

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
        User user = new User();
        user.setName(form.getName());
        user.setReading(form.getReading());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        repository.save(user);
        BeanFactory factory = new BeanFactory();
        model.addAttribute("user", factory.createBean(user));
        return "client/complete";
    }
}
