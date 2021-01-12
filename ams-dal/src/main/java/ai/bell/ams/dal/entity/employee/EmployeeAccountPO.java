package ai.bell.ams.dal.entity.employee;

import ai.bell.ams.dal.entity.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author haoyun.zheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "acct_employee_accounts")
public class EmployeeAccountPO extends AbstractEntity {

    /**
     * 员工ID
     * 主键, 同员工ID
     */
    @TableId(type = IdType.INPUT)
    private Long employeeId;

    /**
     * 账户状态
     * 账户状态枚举值: 1.账户已启用; 2.账户已禁用
     */
    private Integer accountState;

}
