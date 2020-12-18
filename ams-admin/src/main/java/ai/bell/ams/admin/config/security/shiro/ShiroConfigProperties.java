package ai.bell.ams.admin.config.security.shiro;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author haoyun.zheng
 */
@Data
@Component
@ConfigurationProperties(prefix = "nuts.shiro", ignoreUnknownFields = false)
@ConditionalOnProperty(name = "nuts.shiro.enabled", havingValue = "true")
public class ShiroConfigProperties {

    private boolean enabled = false;

    private String[] anonymous = {};

    private final Sso sso = new Sso();

    @Data
    public static class Sso {
        private String address;
    }

}

