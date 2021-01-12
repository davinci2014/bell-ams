package ind.nuts.lang.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haoyun.zheng
 */
@Getter
@AllArgsConstructor
public enum EnumLogicStatus {
    /**
     * 正常
     */
    NORMAL(1, "正常"),

    /**
     * 删除
     */
    DELETED(0, "删除"),

    /**
     * 真
     */
    TRUE(1, "真"),

    /**
     * 假
     */
    FALSE(0, "假"),

    /**
     * 是
     */
    YES(1, "是"),

    /**
     * 否
     */
    NO(0, "否");

    private final Integer value;
    private final String description;
}
