package ai.bell.ams.admin.controller.sample;

import ai.bell.ams.dal.entity.department.DepartmentMapper;
import ai.bell.ams.dal.entity.department.DepartmentPO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haoyun.zheng
 */
@RestController
public class TestRestController {

    @Resource
    private DepartmentMapper departmentMapper;

    @GetMapping("/test")
    public ResponseEntity<?> mybatisPlusInsert() {

        List<DepartmentPO> departmentPOS = departmentMapper.selectList(null);

        return ResponseEntity.ok(departmentPOS);
    }
}
