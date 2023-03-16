package com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionStatusVo {

    private Integer status;
    private String name;
}
