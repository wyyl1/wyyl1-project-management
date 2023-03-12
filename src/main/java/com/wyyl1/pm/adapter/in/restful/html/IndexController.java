package com.wyyl1.pm.adapter.in.restful.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*@RequestMapping("/footer")
    public String footer() {
        return "footer";
    }*/
}
