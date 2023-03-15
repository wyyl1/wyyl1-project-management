package com.wyyl1.pm.adapter.in.restful.proj.function;

import com.wyyl1.pm.adapter.in.restful.common.RestfulPage;
import com.wyyl1.pm.adapter.in.restful.proj.function.creator.FunctionVosCreator;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.form.FunctionSaveForm;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.query.FunctionPageQuery;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo.FunctionVo;
import com.wyyl1.pm.application.proj.function.FunctionService;
import com.wyyl1.pm.common.page.Page;
import com.wyyl1.pm.common.page.PageQuery;
import com.wyyl1.pm.common.util.JsonFormatter;
import com.wyyl1.pm.common.util.Time;
import com.wyyl1.pm.domain.org.employee.EmployeeRepository;
import com.wyyl1.pm.domain.org.platform.PlatformRepository;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import com.wyyl1.pm.domain.proj.function.pojo.query.FunctionListQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/function")
@Slf4j
public class FunctionController {

    private FunctionService service;
    private EmployeeRepository employeeRepository;
    private PlatformRepository platformRepository;

    @PostMapping("/save")
    public void save(@RequestBody FunctionSaveForm form) {
        log.info("新增功能\n{}", JsonFormatter.beautify(form));

        Function function = new Function();
        BeanUtils.copyProperties(form, function);

        // TODO 待实现逻辑
        function.setDelayed(0);
        function.setCreateBy(1);
        function.setCreateAt(Time.now());
        service.save(function);
    }

    @GetMapping("/page")
    @ResponseBody
    public RestfulPage<FunctionVo> page(@Valid FunctionPageQuery pageQuery) {
        FunctionListQuery functionListQuery = new FunctionListQuery();
        BeanUtils.copyProperties(pageQuery, functionListQuery);

        Page<Function> page = service.page(functionListQuery, PageQuery.of(pageQuery.getPageNum(), pageQuery.getPageSize()));
        Page<FunctionVo> result = Page.of(page.pageNum(), page.pageSize(), page.recordTotal());
        result.dataList(new FunctionVosCreator(page.dataList(), employeeRepository, platformRepository).of());

        return RestfulPage.of(result);
    }

}
