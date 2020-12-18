package ai.bell.ams.admin.controller.authentication;

import ai.bell.ams.admin.controller.authentication.fb.UsernamePasswordFB;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;


/**
 * 统一认证模块 - 登录接口
 *
 * @author haoyun.zheng
 */
@RestController
public class LoginDataController {

    @PostMapping("/authentication/login")
    public ResponseEntity<?> login(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                                   @RequestBody UsernamePasswordFB usernamePasswordFB) {
        return ResponseEntity.ok().build();
    }

}
