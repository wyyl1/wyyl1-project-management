package com.wyyl1.pm.domain.proj.function;

import lombok.Getter;

@Getter
public enum FunctionStatusEnum {

    DEVELOPING(1, "开发中"),
    TESTING(2, "测试中"),
    NOT_RELEASED(3, "未发"),
    RELEASED(4, "已发");

    private int status;
    private String name;

    FunctionStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public static FunctionStatusEnum of(Integer status) {
        for (FunctionStatusEnum functionStatusEnum : FunctionStatusEnum.values()) {
            if (functionStatusEnum.getStatus() == status) {
                return functionStatusEnum;
            }
        }

        return null;
    }
}
