package ai.bell.ams.admin.job.sample;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author haoyun.zheng
 */
@Slf4j
@Component
public class SampleJob {

    @XxlJob("sampleJobHandler")
    public ReturnT<String> execute(String params) {
        log.info("开始执行【测试调度任务】, params = {}", params);
        return ReturnT.SUCCESS;
    }

}

