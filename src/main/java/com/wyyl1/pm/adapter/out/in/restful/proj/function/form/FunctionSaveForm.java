package com.wyyl1.pm.adapter.out.in.restful.proj.function.form;

import lombok.Data;

@Data
public class FunctionSaveForm {

    /**
     * 功能名称
     */
    private String name;

    /**
     * 文档链接
     */
    private String documentLink;

    /**
     * 功能发起人id
     */
    private Integer originatorId;

    /**
     * 参与人id列表
     */
    private String participantIds;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 计划提测日期
     */
    private Integer plannedTestDate;

    /**
     * 实际提测日期
     */
    private Integer actualTestDate;

    /**
     * 计划发布日期
     */
    private Integer plannedReleaseDate;

    /**
     * 计划发布日期
     */
    private Integer actualReleaseDate;

    /**
     * 功能状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}
