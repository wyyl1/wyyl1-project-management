package com.wyyl1.pm.adapter.in.restful.proj.function;

import com.wyyl1.pm.adapter.in.restful.proj.function.form.FunctionSaveForm;
import com.wyyl1.pm.application.proj.function.FunctionService;
import com.wyyl1.pm.common.util.JsonFormatter;
import com.wyyl1.pm.common.util.Time;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/function")
public class FunctionController {

    private FunctionService service;

    @PostMapping("/save")
    public String save(@RequestBody FunctionSaveForm form) {
        System.out.println(JsonFormatter.beautify(form));
        Function function = new Function();
        BeanUtils.copyProperties(form, function);

        // TODO 待实现逻辑
        function.setDelayed(0);
        function.setCreateBy(1);
        function.setCreateAt(Time.now());
        service.save(function);

        return "ok";
    }

}
