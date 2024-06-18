package jp.co.creambakery.controller.item;

// import org.aspectj.internal.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jp.co.creambakery.form.*;
import jp.co.creambakery.repository.ItemRepository;



/**
 *非ログイン者用の入力＆完了コントローラー 
 */

@Controller
@RequestMapping("/order")
public class OrderInputController 
{
    @Autowired
    ItemRepository repository;


    @GetMapping("/form")
    public String inputInformationGet(@ModelAttribute OrderForm form)
    {
        return "order/form";
    }


    @PostMapping("/form")
    public String inputInformationPost(@ModelAttribute OrderForm form, Model model)
    {
        model.addAttribute("inputName", form.getName());
        model.addAttribute("inputPostCode", form.getPostCode());
        model.addAttribute("inputAddress", form.getAddress());
        model.addAttribute("inputEmail", form.getEmail());

        return "order/complete";
    }
}

