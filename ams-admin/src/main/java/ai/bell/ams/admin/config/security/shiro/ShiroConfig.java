package ai.bell.ams.admin.config.security.shiro;

import ai.bell.ams.admin.config.security.shiro.constant.ShiroFilterConst;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author haoyun.zheng
 */
@Configuration
@RequiredArgsConstructor
@ConditionalOnBean(ShiroConfigProperties.class)
public class ShiroConfig {

    public static final String LOGIN_URL = "/authentication/login/index.html";

    private final ShiroConfigProperties shiroConfigProperties;

    @Bean
    public DefaultWebSessionManager defaultSessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionValidationSchedulerEnabled(false);

        return defaultWebSessionManager;
    }

    @Bean
    public DefaultSubjectDAO defaultSubjectDAO() {
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);

        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        defaultSubjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);

        return defaultSubjectDAO;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(DefaultSessionManager sessionManager,
                                                               DefaultSubjectDAO defaultSubjectDAO) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        defaultWebSecurityManager.setRealm(new StatelessRealm());
        defaultWebSecurityManager.setSubjectFactory(new StatelessSubjectFactory());
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setSubjectDAO(defaultSubjectDAO);

        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilters(customFilters());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(defaultFilterChainDefinitionMap());

        return shiroFilterFactoryBean;
    }

    /**
     * 设置自定义的Filter
     * 在Shiro提供的默认Filter无法实现业务需求时, 可以根据业务自定义Filter, 并将自定义的Filter注册到Shiro中
     * <p>
     * Created by haoyun.zheng
     */
    private LinkedHashMap<String, Filter> customFilters() {
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();

        filters.put(ShiroFilterConst.STATELESS, new StatelessFilter(shiroConfigProperties));

        return filters;
    }

    /**
     * 设置默认的过滤规则
     * Shiro默认提供了一些过滤器的实现, 具体对应可参考[http://shiro.apache.org/web.html#default-filters]
     * <p>
     * Created by haoyun.zheng
     */
    private LinkedHashMap<String, String> defaultFilterChainDefinitionMap() {
        LinkedHashMap<String, String> filterChainMap = new LinkedHashMap<>();

        // 配置可访问的通用资源文件
        filterChainMap.put("/static/**", ShiroFilterConst.ANONYMOUS);
        filterChainMap.put("/public/**", ShiroFilterConst.ANONYMOUS);
        filterChainMap.put("/favicon.ico", ShiroFilterConst.ANONYMOUS);

        // 配置可访问的通用接口
        filterChainMap.put("/authentication/login/index.html", ShiroFilterConst.ANONYMOUS);
        filterChainMap.put("/authentication/login", ShiroFilterConst.ANONYMOUS);

        // 配置自定义的可访问接口
        for (String anonymous: shiroConfigProperties.getAnonymous()) {
            filterChainMap.put(anonymous, ShiroFilterConst.ANONYMOUS);
        }

        filterChainMap.put("/**", ShiroFilterConst.STATELESS);

        return filterChainMap;
    }

}
