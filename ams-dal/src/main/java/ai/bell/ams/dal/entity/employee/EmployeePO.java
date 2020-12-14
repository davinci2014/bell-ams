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
@TableName(value = "acct_employees")
public class EmployeePO extends AbstractEntity {

    /**
     * 员工ID
     * 员工主键
     */
    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 员工手机号
     * 非空, 唯一
     */
    private String employeePhone;

    /**
     * 员工姓名
     * 非空
     */
    private String employeeName;

    /**
     * 员工归属部门ID
     * 非空
     */
    private Long employeeDepartmentId;

    /**
     * 员工状态
     * 员工状态枚举值, 非空
     */
    private Integer employeeState;

    // TODO 其他业务字段

}
