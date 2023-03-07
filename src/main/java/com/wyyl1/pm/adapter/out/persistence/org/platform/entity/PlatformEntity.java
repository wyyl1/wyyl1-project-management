package com.wyyl1.pm.adapter.out.persistence.org.platform.entity;

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
 * PlatformEntity: 数据映射实体定义
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
    table = "platform",
    schema = "project-management",
    useDao = false,
    desc = "平台"
)
public class PlatformEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId(
      value = "id",
      auto = false
  )
  private Integer id;

  @TableField(
      value = "name",
      desc = "平台名称"
  )
  private String name;

  @Override
  public final Class entityClass() {
    return PlatformEntity.class;
  }
}
