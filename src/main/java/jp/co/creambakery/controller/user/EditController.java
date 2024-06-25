package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jakarta.validation.*;
import jp.co.creambakery.repository.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.form.*;

/**
 * ユーザがユーザ情報を編集するためのコントローラー
 */
@Controller
@RequestMapping(path = "/edit")
public class EditController {

    @Autowired
    UserRepository userRepository;

    /**
     * ユーザ情報の入力画面を表示
     * @param form
     * @param session
     * @param model
     * @return "user/edit/input"
     */
    @GetMapping
    public String input(@ModelAttribute("form") UserEditForm form, HttpSession session, Model model) {
        {
            var factory = new BeanFactory();
            session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        form.populateWith(factory.createBean(user));
        session.setAttribute("user", factory.createBean(user));
        return "user/edit/input";
    }

    /**
     * ユーザ情報を更新し、完了画面の表示
     * @param form
     * @param result
     * @param session
     * @param model
     * @return "user/edit/complete"
     */
    @PostMapping
    public String complete(@Valid @ModelAttribute("form") UserEditForm form, BindingResult result,  HttpSession session, Model model) {
        if (result.hasErrors()){
        return "user/edit/input";
        }
        {
            var factory = new BeanFactory();
            session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        form.populate(user);
        user = userRepository.save(user);
        session.setAttribute("user", user);
        return "user/edit/complete";
    }

    private UserBean getUser(HttpSession session) {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }
}
