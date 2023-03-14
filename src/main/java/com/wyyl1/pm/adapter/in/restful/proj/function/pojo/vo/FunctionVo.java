package com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionVo {
    private Integer id;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 文档链接
     */
    private String documentLink;

    /**
     * 功能发起人花名
     */
    private String originatorName;

    /**
     * 参与人花名列表
     */
    private String participantNames;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

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
     * 功能状态名称
     */
    private Integer statusName;

    /**
     * 已延期
     */
    private Integer delayed;

    /**
     * 备注
     */
    private String remark;

    private Long createAt;

    private Integer createBy;
}
