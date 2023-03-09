package com.wyyl1.pm.domain.proj.function.pojo.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Function {

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
     * 已延期
     */
    private Integer delayed;

    /**
     * 备注
     */
    private String remark;

    private Long createAt;

    private Integer createBy;

    private Long lastUpdatedAt;

    private Integer lastUpdatedBy;
}
