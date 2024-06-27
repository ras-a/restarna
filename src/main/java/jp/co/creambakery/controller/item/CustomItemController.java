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

    @GetMapping("/edit/{itemId}")
    public String editInput(Model model, @ModelAttribute CustomItemForm form ,@PathVariable Integer itemId) {
        var factory = new BeanFactory();
        var creamEntity = creamRepository.findAll();
        var breadEntity = breadRepository.findAll();
        var bean = getUser();
        var user = userRepository.getReferenceById(bean.getId());
        var item = itemRepository.getReferenceById(itemId);
        form.populateWith(item);
        model.addAttribute("item", factory.createBean(item));
        model.addAttribute("creams", factory.createCreamList(creamEntity));
        model.addAttribute("breads", factory.createBreadList(breadEntity));
        session.setAttribute("user", factory.createBean(user));
        return "item/custom/edit";
    }

    @PostMapping("/edit/{itemId}")
    public String editComplete(Model model, @ModelAttribute CustomItemForm form, @PathVariable Integer itemId) {
        BeanFactory factory = new BeanFactory();
        var userBean = (UserBean) session.getAttribute("user");
        var user = userRepository.getReferenceById(userBean.getId());
        var item = user.getCreatedItems().stream().filter(i -> i.getItem().getId() == itemId).findFirst().orElse(null).getItem();
        form.populate(item);

        user = userRepository.save(user);        
        model.addAttribute("item", factory.createBean(item));
        session.setAttribute("user", factory.createBean(user));
        return "item/custom/list";
    }

    private UserBean getUser() {
        var user = (UserBean) session.getAttribute("user");

        if (user == null)
            throw new IllegalStateException("ログインされていない");

        return user;
    }
}




