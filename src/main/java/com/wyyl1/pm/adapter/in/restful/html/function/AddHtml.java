package com.wyyl1.pm.adapter.in.restful.html.function;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/function")
@AllArgsConstructor
public class AddHtml {

    @RequestMapping("/add")
    public String index(Model model) {
        model.addAttribute("title", "添加功能");

        return "function/add";
    }
}
