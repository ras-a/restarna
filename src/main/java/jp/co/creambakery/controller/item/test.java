package jp.co.creambakery.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("/test")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/test2")
    public String topMenu() {
        return "user/home";
    }

    @RequestMapping("/test3")
    public String list() {
        return "item/list";
    }
    
    @RequestMapping("/test4")
    public String detail() {
        return "item/detail";
    }
    
    @RequestMapping("/test5")
    public String creamList() {
        return "item/creamList";
    }

    @RequestMapping("/test6")
    public String cartlistt() {
        return "order/cartList";
    }
}
