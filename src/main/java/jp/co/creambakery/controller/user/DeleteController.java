package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.repository.*;
import jp.co.creambakery.bean.*;

@Controller
@RequestMapping(path = "/delete")
public class DeleteController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String input(HttpSession session, Model model) {
        {
            var factory = new BeanFactory();
            session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        session.setAttribute("user", factory.createBean(user));
        return "user/delete/input";
    }

    @GetMapping(path = "/complete")
    public String complete(HttpSession session, Model model) {
        {
            var factory = new BeanFactory();
            session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        userRepository.delete(user);
        session.removeAttribute("user");
        return "user/delete/complete";
    }

    private UserBean getUser(HttpSession session) {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }
}
