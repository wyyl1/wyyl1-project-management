package com.wyyl1.pm.adapter.in.restful.proj.function.pojo.query;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class FunctionPageQuery {

    // 平台id
    private Integer platformId;

    @NotNull
    @Min(value = 1, message = "页码最小值为 1")
    private Integer pageNum;

    @NotNull
    @Min(value = 1, message = "每页最小显示数量为 1")
    @Max(value = 100, message = "每页最大显示数量为 100")
    private Integer pageSize;
}
