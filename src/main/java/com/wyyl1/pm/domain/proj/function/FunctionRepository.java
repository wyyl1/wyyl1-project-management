package com.wyyl1.pm.domain.proj.function;

import com.wyyl1.pm.common.page.Page;
import com.wyyl1.pm.common.page.PageQuery;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import com.wyyl1.pm.domain.proj.function.pojo.query.FunctionListQuery;

public interface FunctionRepository {

    void save(Function function);

    Page<Function> page(FunctionListQuery listQuery, PageQuery pageQuery);
}
