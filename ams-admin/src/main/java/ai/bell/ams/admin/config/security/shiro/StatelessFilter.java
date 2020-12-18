package ai.bell.ams.admin.config.security.shiro;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BearerHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author haoyun.zheng
 */
@AllArgsConstructor
public class StatelessFilter extends BearerHttpAuthenticationFilter {

    private static final String BEARER = "Bearer ";
    private static final String X_REQUESTED_WITH = "X-Requested-With";
    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    private static final String LOGIN_URI = "/authentication/login/index.html";

    private ShiroConfigProperties shiroConfigProperties;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String authorizationHeader = getAuthzHeader(request);
        if (StringUtils.isBlank(authorizationHeader)) {
            return false;
        }

        if (authorizationHeader.startsWith(BEARER)) {
            String token = RegExUtils.removeFirst(authorizationHeader, BEARER);
            return StringUtils.isNotBlank(token);
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);

        String loginUrl = shiroConfigProperties.getSso().getAddress() + LOGIN_URI;
        String redirectUrl = getRedirectUrl(httpServletRequest);

        if (XML_HTTP_REQUEST.equalsIgnoreCase(httpServletRequest.getHeader(X_REQUESTED_WITH))) {
            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("loginUrl", loginUrl);
            jsonObject.addProperty("redirectUrl", redirectUrl);

            PrintWriter printWriter = response.getWriter();
            printWriter.print(jsonObject.toString());
            printWriter.flush();
            printWriter.close();
        } else {
            Map<String, String> queryParams = Maps.newHashMap();
            queryParams.put("redirectUrl", redirectUrl);

            WebUtils.issueRedirect(request, response, loginUrl, queryParams, true, true);
        }

        return false;
    }

    private String getRedirectUrl(HttpServletRequest httpServletRequest) {
        StringBuffer redirectUrl = httpServletRequest.getRequestURL();
        if (StringUtils.isNotBlank(httpServletRequest.getQueryString())) {
            redirectUrl.append("?").append(httpServletRequest.getQueryString());
        }

        return redirectUrl.toString();
    }

}