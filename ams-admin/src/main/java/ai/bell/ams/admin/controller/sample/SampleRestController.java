package ai.bell.ams.admin.controller.sample;

import ai.bell.ams.dal.entity.sample.SampleMapper;
import ai.bell.ams.dal.entity.sample.SamplePO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haoyun.zheng
 */
@Api(value = "测试模块", tags = {"测试模块相关接口"})
@RestController
@RequestMapping("/sample")
public class SampleRestController {

    @Resource
    private SampleMapper sampleMapper;

    @ApiOperation(
            value = "Swagger注解测试方法",
            notes = "此方法用于测试Swagger注解常用用法"
    )
    @PostMapping(value = {"/swaggerApiAnnotations"},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> swaggerApiAnnotations(@RequestParam("sampleId") Long sampleId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mybatisPlus")
    public ResponseEntity<?> mybatisPlus() {
        List<SamplePO> samples = sampleMapper.selectList(null);
        return ResponseEntity.ok(samples);
    }

    @GetMapping("/mybatisPlus/insert")
    public ResponseEntity<?> mybatisPlusInsert() {
        SamplePO samplePO = new SamplePO();
        samplePO.setId(2L);
        samplePO.setName("testName");

        sampleMapper.insert(samplePO);
        return ResponseEntity.ok().build();
    }
}
