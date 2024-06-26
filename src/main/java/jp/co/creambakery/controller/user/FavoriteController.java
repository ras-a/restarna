package jp.co.creambakery.controller.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;

/**
 * お気に入り一覧表示するためのコントローラー
 */
@Controller
@RequestMapping(path = "/favorite")
public class FavoriteController {

    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;

    /**
     * お気に入りの一覧表示
     * 
     * @param session HTTPセッション
     * @return "user/favorite"
     */
    @GetMapping
    public String showFavorite(HttpSession session) {
        return "user/favorite";
    }

    @GetMapping("/add/{itemId}")
    public String add(HttpSession session, @PathVariable Integer itemId, Model model) {
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());

        Item item = itemRepository.getReferenceById(itemId);
        user.getFavorites().add(item);
        user = userRepository.save(user);
        session.setAttribute("user", factory.createBean(user));
        return "redirect:/item/list";
    }

    @GetMapping("/cancel/{itemId}")
    public String cancel(HttpSession session, @PathVariable Integer itemId, Model model) {
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        Item item = itemRepository.getReferenceById(itemId);
        user.getFavorites().remove(item);
        user = userRepository.save(user);
        session.setAttribute("user", factory.createBean(user));
        return "redirect:/user/favorite";
    }

    @GetMapping("/cancel/list/{itemId}")
    public String listCancel(HttpSession session, @PathVariable Integer itemId, Model model) {
        var factory = new BeanFactory();
        var bean = getUser(session);
        var user = userRepository.getReferenceById(bean.getId());
        Item item = itemRepository.getReferenceById(itemId);
        user.getFavorites().remove(item);
        user = userRepository.save(user);
        session.setAttribute("user", factory.createBean(user));
        return "redirect:/item/list";
    }

    private UserBean getUser(HttpSession session) {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }

}