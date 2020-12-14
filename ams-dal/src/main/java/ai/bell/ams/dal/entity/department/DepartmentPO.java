package ai.bell.ams.dal.entity.department;

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
@TableName(value = "dept_departments")
public class DepartmentPO extends AbstractEntity {

    @TableId(type = IdType.INPUT)
    private Long id;

    private String name;

    private Long parentId;

    private String parentDeptIds;

    // TODO 其他业务字段
}
