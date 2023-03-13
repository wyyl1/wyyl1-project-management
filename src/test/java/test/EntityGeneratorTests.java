package test;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Column;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;
import org.junit.jupiter.api.Test;

public class EntityGeneratorTests {

    static final String url = "jdbc:mysql://localhost:3306/project-management?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true";

    // org.platform
    // org.employee
    // proj.function
    static final String MODEL = "org.employee";

    @Test
    public void generate() {
        FileGenerator.build(Empty.class);
    }

    @Tables(
            /* 数据库连接信息 **/
            url = url, username = "root", password = "root",
            /* Entity类parent package路径 **/
            basePack = "com.wyyl1.pm.adapter.out.persistence." + MODEL,
            /* Entity代码源目录 **/
            srcDir = "src/main/java/",
            /* Dao代码源目录 **/
//            daoDir = "src/main/java/",
            /* 如果表定义记录创建，记录修改，逻辑删除字段 **/
            gmtCreated = "gmt_created", gmtModified = "gmt_modified", logicDeleted = "is_deleted",
            /* 需要生成文件的表 ( 表名称:对应的Entity名称 ) **/
            tables = @Table(
                    value = {
                            "employee:Employee"
                    },
                    columns = @Column(value = "gender_man", javaType = Boolean.class)
            ),
            // Entity 字段顺序按数据库定义顺序选项
            alphabetOrder = false
    )
    static class Empty {
    }
}
