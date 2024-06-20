package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.repository.*;
import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;

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
        var customer = (CustomerBean) session.getAttribute("user");
        model.addAttribute("favorites", repository.findAllByOwnerId(customer.getId()));
        return "client/favorite";
    }
}