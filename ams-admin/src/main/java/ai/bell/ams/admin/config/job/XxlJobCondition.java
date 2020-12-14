package ai.bell.ams.admin.config.job;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author haoyun.zheng
 */
public class XxlJobCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] profiles = context.getEnvironment().getActiveProfiles();

        for (String profile : profiles) {
            if ("local".equals(profile)) {
                return false;
            }
        }

        return true;
    }

}
