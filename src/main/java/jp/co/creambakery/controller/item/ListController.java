package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import jp.co.creambakery.repository.*;

@Controller
public class ListController
{
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CreamRepository creamRepository;

    @GetMapping("/list")
    public String home(Model model)
    {
        model.addAttribute("items", itemRepository.findAll());
        return "item/test";
    }

    @GetMapping("/cream/list")
    public String cream(Model model)
    {
        model.addAttribute("creams", creamRepository.findAll());
        return "item/test";
    }
}
