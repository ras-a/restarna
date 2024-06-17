package jp.co.creambakery.controller.item;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;

/**
 * カート追加・内容を処理するコントローラー
 */
@Controller
@RequestMapping(path = "/cart")
public class OrderController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CustomerRepository customerRepository;

    /**
     * 商品を選択後、選んだ商品を表示し、カートに追加または戻る
     * 
     * @param id 商品ID
     * @param model モデル
     * @return "cartAdd"
     */
    @GetMapping(path = "/add/{id}")
    public String cartAdd(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemRepository.getReferenceById(id));
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
    @GetMapping(path = "/list/{id}")
    public String cartDetail(@PathVariable Integer id, HttpSession session, Model model) {

        // アイテムIDを取得
        Integer itemId = id;

        // テスト用ユーザIDを設定
        session.setAttribute("id", 1);

        // セッションから顧客IDを取得（仮にIntegerとして扱う例）
        Integer customerId = (Integer) session.getAttribute("id");

        // 顧客IDを使ってカートを取得する
        List<Cart> cart = cartRepository.findAllByCustomer_Id(customerId);   

        // カートの中にそのアイテムがあるかどうかの判定結果を保存する
        boolean itemFound = false;

        // カートの中からitemIdと同じIDを持つカートアイテムを探す
        for (Cart cartItem : cart) {
            if (itemId.equals(cartItem.getItem().getId())) {
                // 同じIDのアイテムが見つかった場合、数量をインクリメントする
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartRepository.save(cartItem); // 変更をデータベースに保存する
                itemFound = true;
                break;
            }
        }
    
        // itemIdに対応するカートアイテムが見つからなかった場合、新しいカートアイテムを作成する
        if (!itemFound) {
            Cart newCartItem = new Cart();
            newCartItem.setCustomer(customerRepository.getReferenceById(customerId));
            newCartItem.setItem(itemRepository.getReferenceById(itemId));
            newCartItem.setQuantity(1);
            cartRepository.save(newCartItem);
            cart.add(newCartItem); // 新しいカートアイテムをカートリストに追加する
        }

        model.addAttribute("cart", cart);

        return "order/cartList";
    }
}
