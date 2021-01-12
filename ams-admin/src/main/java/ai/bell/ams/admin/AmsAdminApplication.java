package ai.bell.ams.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author haoyun.zheng
 */
@SpringBootApplication(scanBasePackages = {"ai.bell.ams"})
public class AmsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmsAdminApplication.class, args);
    }

}
