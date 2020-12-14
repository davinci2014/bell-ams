package ai.bell.ams.dal.entity.base;

import lombok.Data;

import java.util.Date;

/**
 * @author haoyun.zheng
 */
@Data
public abstract class AbstractEntity {

    private Long createdBy;

    private Date createdAt;

    private Long updatedBy;

    private Date updatedAt;

    private Integer status;
}
