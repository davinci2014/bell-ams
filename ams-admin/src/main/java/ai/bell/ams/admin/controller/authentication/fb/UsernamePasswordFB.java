package ai.bell.ams.admin.controller.authentication.fb;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author haoyun.zheng
 */
@Data
public class UsernamePasswordFB {

    @NotNull(message = "使用账号密码登录时, 账号不可为空")
    private String username;

    @NotNull(message = "使用账号密码登录时, 密码不可为空")
    private String password;

}
