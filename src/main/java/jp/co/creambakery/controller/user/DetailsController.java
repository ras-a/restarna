package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.repository.*;
import jp.co.creambakery.bean.*;

@Controller
public class DetailsController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/details")
    public String userInfo(HttpSession session, Model model) {
        {
            var factory = new BeanFactory();
            session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());       
        session.setAttribute("user", factory.createBean(user));
        return "user/details";
    }
    
    private UserBean getUser(HttpSession session) {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }
}
