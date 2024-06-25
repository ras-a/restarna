package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;

/**
 * カート追加・内容を処理するコントローラー
 */
@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    HttpSession session;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 商品を選択後、選んだ商品を表示し、カートに追加または戻る
     * 
     * @param itemId 商品ID
     * @param model モデル
     * @return "order/cart/add"
     */
    @GetMapping(path = "/add/{itemId}")
    public String cartAdd(@PathVariable Integer itemId, Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("item", factory.createBean(itemRepository.getReferenceById(itemId)));
        return "order/cart/add";
    }

    /**
     * 指定された商品をカートに追加し、カートの内容を表示する
     * 
     * @param itemId    商品ID
     * @param quantity 商品の個数
     * @param session HTTPSession
     * @param model モデル
     * @return "order/cart/list"
     */
    @PostMapping(path = "/add/{itemId}")
    public String cartAdd(@PathVariable Integer itemId, @RequestParam Integer quantity,
            Model model) {
        {
        var factory = new BeanFactory();
        session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));
        }
        var factory = new BeanFactory();
        var bean = getUser();
        var user = userRepository.getReferenceById(bean.getId());

        Boolean itemFound = false;

        // カートの中からitemIdと同じIDを持つカートアイテムを探す
        for (var item : user.getCart()) {
            if (item.getItem().getId() == itemId) {
                // 同じIDのアイテムが見つかった場合、数量をインクリメントする
                item.setQuantity(item.getQuantity() + quantity);
                user = userRepository.save(user);
                itemFound = true;
                break;
            }
        }

        // itemIdに対応するカートアイテムが見つからなかった場合、新しいカートアイテムを作成する
        if (!itemFound) {
            var cartItem = new Cart();
            cartItem.setUser(userRepository.getReferenceById(user.getId()));
            cartItem.setItem(itemRepository.getReferenceById(itemId));
            cartItem.setQuantity(quantity);
            user.getCart().add(cartItem); // 新しいカートアイテムをカートリストに追加する
            user = userRepository.save(user);
        }

        session.setAttribute("user", factory.createBean(user));

        return "order/cart/list";
    }

    /**
     * カートの内容を表示する
     * 
     * @param session HTTPSession
     * @param model モデル
     * @return "order/cart/list"
     */
    @GetMapping("/list")
    public String cartList(Model model) {
        return "order/cart/list";
    }

    /**
     * 商品の個数を編集する画面
     * @param session HTTPSession
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping(path = "/edit/{itemId}")
    public String edit(@PathVariable Integer itemId, Model model) {

        var factory = new BeanFactory();
        var bean = getUser();
        var user = userRepository.getReferenceById(bean.getId());

        Item item = itemRepository.getReferenceById(itemId);
        Cart cart = cartRepository.findByUserAndItem(user, item);
        factory.createBean(cart);

        model.addAttribute("item", factory.createBean(itemRepository.getReferenceById(itemId)));
        model.addAttribute("quantity", cart.getQuantity());
        return "order/cart/edit";
    }

    /**
     * 編集した商品の個数を適応し、カートの内容を表示する
     * @param session HTTPSession
     * @param itemId    商品ID
     * @param quantity
     * @param model モデル
     * @return
     */
    @PostMapping("/edit/complete/{itemId}")
    public String editComplete(@PathVariable Integer itemId,
                @RequestParam Integer quantity, Model model) {

        var factory = new BeanFactory();
        var bean = getUser();
        var user = userRepository.getReferenceById(bean.getId());

        // カートの中からitemIdと同じIDを持つカートアイテムを探す
        for (var item : user.getCart()) {
            if (item.getItem().getId() == itemId) {
                // 同じIDのアイテムが見つかった場合、数量をインクリメントする
                item.setQuantity(quantity);
                break;
            }
        }

        user = userRepository.save(user);

        session.setAttribute("user", factory.createBean(user));

        return "order/cart/list";
    }

    private UserBean getUser() {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }
}
