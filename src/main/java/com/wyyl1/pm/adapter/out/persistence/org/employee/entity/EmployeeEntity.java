package com.wyyl1.pm.adapter.out.persistence.org.employee.entity;

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
 * EmployeeEntity: 数据映射实体定义
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
    table = "employee",
    schema = "project-management",
    useDao = false,
    desc = "员工"
)
public class EmployeeEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "id",
      auto = false
  )
  private Integer id;

  @TableField(
      value = "nickname",
      desc = "花名"
  )
  private String nickname;

  @TableField(
      value = "department_id",
      desc = "部门id"
  )
  private Integer departmentId;

  @Override
  public final Class entityClass() {
    return EmployeeEntity.class;
  }
}
