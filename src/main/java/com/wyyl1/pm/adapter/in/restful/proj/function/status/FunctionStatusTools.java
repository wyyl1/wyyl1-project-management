package com.wyyl1.pm.adapter.in.restful.proj.function.status;

import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo.FunctionStatusVo;
import com.wyyl1.pm.domain.proj.function.FunctionStatusEnum;

import java.util.Arrays;
import java.util.List;

public class FunctionStatusTools {

    public static final List<FunctionStatusVo> allStatus() {
        return Arrays.stream(FunctionStatusEnum.values())
                .map(FunctionStatusTools::toVo)
                .toList();
    }

    private static FunctionStatusVo toVo(FunctionStatusEnum functionStatusEnum) {
        return FunctionStatusVo.builder()
                .status(functionStatusEnum.getStatus())
                .name(functionStatusEnum.getName())
                .build();
    }
}
