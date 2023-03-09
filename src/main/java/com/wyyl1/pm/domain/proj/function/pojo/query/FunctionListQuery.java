package com.wyyl1.pm.domain.proj.function.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能列表查询
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FunctionListQuery {

    // 平台id
    private Integer platformId;
}
