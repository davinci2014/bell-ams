package ai.bell.ams.biz.service.authentication;

import ai.bell.ams.biz.service.AbstractService;
import ai.bell.ams.dal.entity.base.AbstractEntity;
import ai.bell.ams.dal.entity.employee.EmployeeAccountPO;
import ai.bell.ams.dal.entity.employee.EmployeePO;
import ai.bell.ams.dal.entity.employee.mapper.EmployeeAccountMapper;
import ai.bell.ams.dal.entity.employee.mapper.EmployeeMapper;
import ai.bell.ams.spi.enums.employee.EnumEmployeeAccountState;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ind.nuts.lang.enums.EnumLogicStatus;
import ind.nuts.lang.utils.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haoyun.zheng
 */
@Slf4j
@Service
public class LoginService extends AbstractService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeAccountMapper employeeAccountMapper;

    public void login(String username, String password) {
        AssertUtil.notEmpty(username, "使用账号密码登录时, 账号不可为空");
        AssertUtil.notEmpty(password, "使用账号密码登录时, 密码不可为空");

        // 首先查询用户是否存在
        EmployeePO employee = employeeMapper.selectOne(new QueryWrapper<EmployeePO>()
                .lambda()
                .eq(AbstractEntity::getStatus, EnumLogicStatus.NORMAL.getValue())
                .eq(EmployeePO::getEmployeePhone, username)
        );
        AssertUtil.notNull(employee, String.format("账号[%s]不存在", username));

        // 再查询用户账号是否开启
        EmployeeAccountPO employeeAccount = employeeAccountMapper.selectById(employee.getId());
        AssertUtil.notNull(employeeAccount, String.format("用户[%s]未开通账号, 请联系负责人.", employee.getEmployeeName()));
        AssertUtil.truly(EnumEmployeeAccountState.ENABLED.getValue().equals(employeeAccount.getAccountState()), String.format("账号[%s]已禁用", username));

        // 账号业务逻辑验证成功后, 交与Shiro框架进行登录验证
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(usernamePasswordToken);
    }

}
