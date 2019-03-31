package club.lan.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lan
 * @version 1.0.0
 * @since 2019/3/28  22:37
 */
@Controller
@Slf4j
public class TestControllor {

    @RequestMapping("/test")
    @ResponseBody           //不需要返回页面
    public String test() {
        return "test";
    }
}
