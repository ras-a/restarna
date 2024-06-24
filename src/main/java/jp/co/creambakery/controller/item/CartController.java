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
public class CartController 
{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 商品を選択後、選んだ商品を表示し、カートに追加または戻る
     * 
     * @param id 商品ID
     * @param model モデル
     * @return "cartAdd"
     */
    @GetMapping(path = "/add/{id}")
    public String cartAdd(@PathVariable Integer id, Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("item", factory.createBean(itemRepository.getReferenceById(id)));
        return "order/cartAdd";
    }


    /**
     * 指定された商品をカートに追加し、カートの内容を表示する
     * 
     * @param id 商品ID
     * @param session HTTPセッション
     * @param model モデル
     * @return
     */
    @PostMapping(path = "/add/{itemId}")
    public String cartDetail(@PathVariable Integer itemId, @RequestParam Integer quantity, HttpSession session, Model model) {
        var factory = new BeanFactory();

        session.setAttribute("user", factory.createBean(userRepository.getReferenceById(1)));

        var bean = (UserBean) session.getAttribute("user");

        // 顧客IDを使ってカートを取得する
        var user = userRepository.getReferenceById(bean.getId());   

        // カートの中にそのアイテムがあるかどうかの判定結果を保存する
        boolean itemFound = false;

        // カートの中からitemIdと同じIDを持つカートアイテムを探す
        for (var item : user.getCart()) {
            if (item.getItem().getId().equals(itemId) ) {
                // 同じIDのアイテムが見つかった場合、数量をインクリメントする
                item.setQuantity(item.getQuantity() + quantity);
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
        }

        user = userRepository.save(user);

        session.setAttribute("user", factory.createBean(user));

        return "order/cartList";
    }
}
