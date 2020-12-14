package ai.bell.ams.admin.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author haoyun.zheng
 */
@Configuration
@MapperScan("ai.bell.ams.dal.entity")
public class MybatisConfig {

}
