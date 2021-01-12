package ai.bell.ams.admin.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author haoun.zheng
 */
@Controller
public class IndexController {

    @GetMapping(value = {"", "/", "/index", "/index.html", "/home", "/home.html"})
    public String index() {
        return "/index";
    }

}
