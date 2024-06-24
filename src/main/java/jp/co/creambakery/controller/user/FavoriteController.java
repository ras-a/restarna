package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.repository.*;

@Controller
public class FavoriteController
{

    @Autowired
    FavoriteRepository repository;

    BeanFactory factory = new BeanFactory();

/**
 * @param id 顧客ID
 * @param session HTTPセッション
 * @param model　モデル
 * @return
 */

    @GetMapping("/favorite")
    public String showFavorite(HttpSession session, Model model) 
    {
        var customer = (UserBean) session.getAttribute("user");
        model.addAttribute("favorites", repository.findAllByOwnerId(customer.getId()));
        return "user/favorite";
    }
}