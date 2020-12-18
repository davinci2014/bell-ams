package ai.bell.ams.admin.controller.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一认证模块 - 登录页面
 *
 * @author haoyun.zheng
 */
@Controller
public class LoginController {

    @GetMapping("/authentication/login/index.html")
    public String index(HttpServletRequest request, Model model) {
        return "/authentication/login/index";
    }
}
