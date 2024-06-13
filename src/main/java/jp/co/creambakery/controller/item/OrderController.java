package jp.co.creambakery.controller.item;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.creambakery.bean.ItemBean;
import jp.co.creambakery.entity.Item;
import jp.co.creambakery.repository.ItemRepository;

@Controller
@RequestMapping(path = "/cart")
public class OrderController {

    @Autowired
    ItemRepository itemRepository;

    /**
     * 
     * @param model
     * @return
     */
    @GetMapping(path = "/add/{id}")
    public String cartAdd(@PathVariable Integer id, Model model) {
        model.addAttribute("item", itemRepository.getReferenceById(id));
        return "cartAdd";
    }

    /**
     * 
     * @param model
     * @return
     */
    @PostMapping(path = "/list/{id}")
    public String cartDetail(@PathVariable Integer id, Model model) {
        Item item = new Item();
        item = itemRepository.save(item);
        ItemBean itemBean = new ItemBean();
        BeanUtils.copyProperties(item, itemBean);
        model.addAttribute("item",itemBean);
        return "cartList";
    }

}
