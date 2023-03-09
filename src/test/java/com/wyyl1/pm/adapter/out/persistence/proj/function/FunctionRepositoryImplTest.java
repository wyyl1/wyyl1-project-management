package com.wyyl1.pm.adapter.out.persistence.proj.function;

import com.wyyl1.pm.adapter.out.persistence.proj.function.mapper.FunctionMapper;
import com.wyyl1.pm.common.page.Page;
import com.wyyl1.pm.common.page.PageQuery;
import com.wyyl1.pm.common.util.Time;
import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import com.wyyl1.pm.domain.proj.function.pojo.query.FunctionListQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.BaseTest;

import javax.annotation.Resource;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class FunctionRepositoryImplTest extends BaseTest {

    @Resource
    private FunctionRepository repository;

    @Resource
    private FunctionMapper mapper;

    @DisplayName("保存功能")
    @Nested
    class Save {
        @DisplayName("保存成功")
        @Test
        void save_success() {
            Function function = createFunction();

            repository.save(function);

            FunctionCleaner.of(mapper).cleanLastInsert();
        }

        @DisplayName("当功能名称为 null 时抛出异常")
        @Test
        void throws_an_exception_when_the_name_is_null() {
            Function function = createFunction();
            function.setName(null);

            assertThatThrownBy(() -> repository.save(function)).hasCauseInstanceOf(SQLException.class);
        }

        private Function createFunction() {
            Function function = Function.builder()
                    .name("开门")
                    .documentLink("https://www.deepl.com/")
                    .originatorId(1)
                    .participantIds("1,2,3")
                    .platformId(1)
                    .departmentId(1)
                    .plannedTestDate(20230101)
                    .actualTestDate(20230302)
                    .plannedReleaseDate(20230303)
                    .actualReleaseDate(20230304)
                    .status(1)
                    .delayed(0)
                    .remark("测试")
                    .createAt(Time.now())
                    .createBy(1)
                    .build();
            return function;
        }
    }

    @DisplayName("分页查询")
    @Nested
    class PageTest {

        @DisplayName("当 listQuery 为 null 时查询所有记录")
        @Test
        void select_all_rows_when_listQuery_is_null() {
            Page<Function> page = repository.page(null, PageQuery.of(1, 10));

            assertThat(page.recordTotal()).isEqualTo(9);
            assertThat(page.dataList().size()).isEqualTo(9);
        }

        @DisplayName("使用「平台」进行查询")
        @ParameterizedTest
        @CsvSource({
                "1, 10, 0, 0, 0",
                "2, 1, 2, 2, 1",
        })
        void select_by_platform(int pageNum, int pageSize, int platformId, int expectedRecordTotal, int expectedDataListSize) {
            Page<Function> page = repository.page(FunctionListQuery.builder().platformId(platformId).build(), PageQuery.of(pageNum, pageSize));

            assertThat(page.recordTotal()).isEqualTo(expectedRecordTotal);
            assertThat(page.dataList().size()).isEqualTo(expectedDataListSize);
        }

    }

}