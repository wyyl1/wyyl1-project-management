package com.wyyl1.pm.adapter.in.restful.html.function;

import com.wyyl1.pm.adapter.in.restful.common.RestfulPage;
import com.wyyl1.pm.adapter.in.restful.proj.function.FunctionController;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.query.FunctionPageQuery;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo.FunctionVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/function")
@AllArgsConstructor
public class IndexHtml {

    private FunctionController functionController;

    @RequestMapping("/index")
    public String index(@Valid FunctionPageQuery pageQuery, Model model) {
        RestfulPage<FunctionVo> page = functionController.page(pageQuery);
        model.addAttribute("title", "功能列表");
        model.addAttribute("page", page);

        return "function/index";
    }
}
