package com.wyyl1.pm.adapter.in.restful.html;

import com.wyyl1.pm.adapter.in.restful.common.RestfulPage;
import com.wyyl1.pm.adapter.in.restful.proj.function.FunctionController;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.query.FunctionPageQuery;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/function")
@AllArgsConstructor
public class FunctionHtml {

    private FunctionController functionController;

    @RequestMapping("/")
    public String index(@Valid FunctionPageQuery pageQuery, Model model) {
        RestfulPage<Function> page = functionController.page(pageQuery);
        model.addAttribute("title", "功能列表");
        model.addAttribute("page", page);

        return "function/index";
    }
}
