package jp.co.creambakery.controller.session.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ホーム画面のためのコントローラー
 */
@Controller
public class HomePageController {

    /**
     * @return "index"
     */
    @RequestMapping(path = "/home")
    public String home() {
        return "index";
    }
}
