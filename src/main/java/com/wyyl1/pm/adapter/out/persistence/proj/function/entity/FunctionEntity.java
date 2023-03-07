package com.wyyl1.pm.adapter.out.persistence.proj.function.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * FunctionEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@AllArgsConstructor
@NoArgsConstructor
@FluentMybatis(
    table = "function",
    schema = "project-management",
    useDao = false,
    desc = "功能"
)
public class FunctionEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "id",
      auto = false
  )
  private Integer id;

  @TableField(
      value = "name",
      desc = "功能名称"
  )
  private String name;

  @TableField(
      value = "document_link",
      desc = "文档链接"
  )
  private String documentLink;

  @TableField(
      value = "originator_id",
      desc = "功能发起人id"
  )
  private Integer originatorId;

  @TableField(
      value = "participant_ids",
      desc = "参与人id列表"
  )
  private String participantIds;

  @TableField(
      value = "platform_id",
      desc = "平台id"
  )
  private Integer platformId;

  @TableField(
      value = "department_id",
      desc = "部门id"
  )
  private Integer departmentId;

  @TableField(
      value = "planned_test_date",
      desc = "计划提测日期"
  )
  private Integer plannedTestDate;

  @TableField(
      value = "actual_test_date",
      desc = "实际提测日期"
  )
  private Integer actualTestDate;

  @TableField(
      value = "planned_release_date",
      desc = "计划发布日期"
  )
  private Integer plannedReleaseDate;

  @TableField(
      value = "actual_release_date",
      desc = "计划发布日期"
  )
  private Integer actualReleaseDate;

  @TableField(
      value = "status",
      desc = "功能状态"
  )
  private Integer status;

  @TableField(
      value = "delayed",
      desc = "已延期"
  )
  private Integer delayed;

  @TableField(
      value = "remark",
      desc = "备注"
  )
  private String remark;

  @TableField("create_at")
  private Long createAt;

  @TableField("create_by")
  private Integer createBy;

  @TableField("last_updated_at")
  private Integer lastUpdatedAt;

  @TableField("last_updated_by")
  private Integer lastUpdatedBy;

  @Override
  public final Class entityClass() {
    return FunctionEntity.class;
  }
}
