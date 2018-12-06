package cn.joes.controller;

import cn.joes.domain.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by myijoes on 2018/12/6.
 *
 * @author wanqiao
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/demo")
    public String findOneCity(ModelMap map) {
        return "/index";
    }

}
