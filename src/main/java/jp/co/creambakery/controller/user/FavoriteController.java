package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.repository.*;

/**
 * お気に入り一覧表示するためのコントローラー
 */
@Controller
public class FavoriteController
{

    @Autowired
    FavoriteRepository repository;

    BeanFactory factory = new BeanFactory();

/**
 * お気に入りの一覧表示
 * @param session HTTPセッション
 * @param model　モデル
 * @return "user/favorite"
 */
    @GetMapping("/favorite")
    public String showFavorite(HttpSession session) 
    {
        return "user/favorite";
    }
}