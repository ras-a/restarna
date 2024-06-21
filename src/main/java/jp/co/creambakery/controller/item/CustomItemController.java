package jp.co.creambakery.controller.item;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import jp.co.creambakery.bean.*;
import jp.co.creambakery.entity.*;
import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.*;

@Controller
@RequestMapping("/custom")
public class CustomItemController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CreamRepository creamRepository;
    @Autowired
    BreadRepository breadRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    HttpSession session;

    @GetMapping("/input")
    public String getCustomInput(Model model, @ModelAttribute CustomItemForm form) {
        BeanFactory factory = new BeanFactory();
        var creamEntity = creamRepository.findAll();
        var breadEntity = breadRepository.findAll();
        model.addAttribute("creams", factory.createCreamList(creamEntity));
        model.addAttribute("breads", factory.createBreadList(breadEntity));
        return "item/custom/input";
    }

    @PostMapping("/input")
    public String postCustomInput(Model model, @ModelAttribute CustomItemForm form) {
        BeanFactory factory = new BeanFactory();
        var userBean = (UserBean) session.getAttribute("user");
        var user = userRepository.getReferenceById(userBean.getId());
        var item = new Item(user, form.getBread(), form.getCreams() , form);

        itemRepository.save(item);

        user.getCreatedItems().add(item.getCustom());

        user = userRepository.save(user);

        model.addAttribute("item", factory.createBean(item));
        session.setAttribute("user", factory.createBean(user));
        return "item/custom/complete";
    }

    @GetMapping("/{id}")
    public String complete() {
        return "item/custom/list";
    }
}




