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
    @Min(value = 1, message = "页码最小值为1")
    private Integer pageNum;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer pageSize;
}
