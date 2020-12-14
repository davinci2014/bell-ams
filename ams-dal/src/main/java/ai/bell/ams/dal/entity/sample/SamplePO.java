package ai.bell.ams.dal.entity.sample;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author haoyun.zheng
 */
@Data
@TableName("sample")
public class SamplePO {

    private Long id;

    private String name;

}
