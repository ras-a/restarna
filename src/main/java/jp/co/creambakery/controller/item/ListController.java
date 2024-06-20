package jp.co.creambakery.controller.item;
import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class ListController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CreamRepository creamRepository;
    @Autowired
    BreadRepository breadRepository;
    @GetMapping("/list")
    public String list(Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("items", factory.createItemList(itemRepository.findAllNotDeletedByStoreIsNotNull()));
        return "item/list";
    }
    @GetMapping("/cream/list")
    public String cream(Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
        return "item/creamList";
    }
    @GetMapping("/bread/list")
    public String breadList(Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
        return "item/breadList";
    }

    // 絞り込み画面
    @GetMapping("/filter")
    public String squ(Model model) {
        BeanFactory factory = new BeanFactory();
        model.addAttribute("items", factory.createItemList(itemRepository.findAll()));
        model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
        model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
        return "item/search";
    }

    // 生地絞り込み
    @PostMapping("/filters")
    public String breadsq(Model model, String itemName, Integer breadId, Integer creamId) {
        BeanFactory factory = new BeanFactory();

        if (itemName == null)
            itemName = "";

        var bread = breadId != null? breadRepository.getReferenceById(breadId): null;

        var creams = creamId != null? creamRepository.getReferenceById(creamId): null;
        var items = factory.createItemList(itemRepository.findAllByBreadAndCreamsContainsAndNameContaining(bread,creams,itemName));

        model.addAttribute("items", items);
        model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
        model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
        return "item/search";
    }
    
    // 値段並び替え
    @PostMapping("/sort")
    public String sortprice(Model model, String sort) {
        BeanFactory factory = new BeanFactory();
        var items = factory.createItemList(itemRepository.findAllByOrderByPrice());
        int num = Integer.parseInt(sort);
        if (num == 1) {
            model.addAttribute("items", items);
        } else {
            Collections.reverse(items);
            model.addAttribute("items", items);
        }
        model.addAttribute("breads", factory.createBreadList(breadRepository.findAll()));
        model.addAttribute("creams", factory.createCreamList(creamRepository.findAll()));
        return "item/search";
    }
}