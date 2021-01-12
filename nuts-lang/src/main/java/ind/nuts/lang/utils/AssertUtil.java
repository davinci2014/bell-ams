package ind.nuts.lang.utils;

import ind.nuts.lang.exctption.AssertException;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * @author haoyun.zheng
 */
@NoArgsConstructor
public class AssertUtil {

    public static void notNull(Object object, String tips) {
        if (object == null) {
            throw new AssertException(StringUtils.isNotBlank(tips) ? tips : "校验对象为空");
        }
    }

    public static void notEmpty(String string, String tips) {
        if (StringUtils.isBlank(string)) {
            throw new AssertException(StringUtils.isNotBlank(tips) ? tips : "校验对象为空");
        }
    }

    public static void notEmpty(Collection<?> collection, String tips) {
        if (collection == null || collection.size() == 0) {
            throw new AssertException(StringUtils.isNotBlank(tips) ? tips : "校验对象为空");
        }
    }

    public static void truly(Boolean result, String tips) {
        if (result == null || !result) {
            throw new AssertException(StringUtils.isNotBlank(tips) ? tips : "校验对象错误");
        }
    }

}
