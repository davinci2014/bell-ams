package ai.bell.ams.admin.controller.authentication;

import ai.bell.ams.admin.controller.authentication.fb.UsernamePasswordFB;
import ai.bell.ams.biz.service.authentication.LoginService;
import ind.nuts.lang.exctption.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 统一认证模块 - 登录接口
 *
 * @author haoyun.zheng
 */
@Slf4j
@RestController
public class LoginDataController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/authentication/login")
    public ResponseEntity<?> login(@RequestBody @Validated UsernamePasswordFB usernamePassword) {
        try {
            loginService.login(usernamePassword.getUsername(), usernamePassword.getPassword());
        } catch (ServiceException exp) {
            log.error("", exp);
        }

        return ResponseEntity.ok().build();
    }

}
