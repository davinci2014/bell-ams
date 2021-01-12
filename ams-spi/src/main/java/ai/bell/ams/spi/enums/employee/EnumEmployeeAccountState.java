package ai.bell.ams.spi.enums.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author haoyun.zheng
 */
@Getter
@AllArgsConstructor
public enum EnumEmployeeAccountState {

    /**
     * 已禁用
     */
    DISABLED(0, "已禁用"),

    /**
     * 已启用
     */
    ENABLED(1, "已启用");

    private final Integer value;
    private final String description;
}
