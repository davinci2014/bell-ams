package ai.bell.ams.dal.entity.employee;

import ai.bell.ams.dal.entity.base.AbstractEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author haoyun.zheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "acct_employee_accounts")
public class EmployeeAccountPO extends AbstractEntity {

    /**
     * 账户ID
     * 账户自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 员工ID
     * 唯一, 非空
     */
    private Long employeeId;

    /**
     * 账户状态
     * 账户状态枚举值: 1.账户已启用; 2.账户已禁用
     */
    private Integer accountState;

}
