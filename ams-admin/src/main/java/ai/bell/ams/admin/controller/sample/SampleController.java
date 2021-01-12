package ai.bell.ams.admin.controller.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author haoyun.zheng
 */
@Controller
public class SampleController {

    @GetMapping("/sample/index.html")
    public String index(Model model) {
        model.addAttribute("f_string", "freemarker");
        model.addAttribute("f_number", 1.234567890);
        model.addAttribute("f_date", new Date());
        model.addAttribute("f_boolean", true);

        Map<String, Object> map = new HashMap<>();
        map.put("k1", 1);
        model.addAttribute("f_map", map);

        List<String> list = new ArrayList<>();
        list.add("l1");
        list.add("l2");
        model.addAttribute("f_list", list);

        throw new SecurityException("测试名称");
//        return "/sample/index";
    }

}
