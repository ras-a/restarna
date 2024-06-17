package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.repository.*;

@Controller
public class ListController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CreamRepository creamRepository;
    @Autowired
    BreadRepository breadRepository;

    @GetMapping("/list")
    public String home(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "item/test";
    }

    @GetMapping("/cream/list")
    public String cream(Model model) {
        model.addAttribute("creams", creamRepository.findAll());
        return "item/test";
    }

    @GetMapping("/bread/list")
    public String breadItemList(Model model) {
        model.addAttribute("breads", breadRepository.findAll());
        return "test";
    }

    // 絞り込み画面
    @GetMapping("/ssqq")
    public String squ(Model model) {
        model.addAttribute("customs", creamRepository.findAll());
        model.addAttribute("breads", breadRepository.findAll());
        model.addAttribute("items", itemRepository.findAll());

        return "test";

    }
}
