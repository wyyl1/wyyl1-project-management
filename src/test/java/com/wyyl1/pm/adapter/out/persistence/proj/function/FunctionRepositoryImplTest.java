package com.wyyl1.pm.adapter.out.persistence.proj.function;

import com.wyyl1.pm.common.util.Time;
import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.dto.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import javax.annotation.Resource;

class FunctionRepositoryImplTest extends BaseTest {

    @Resource
    private FunctionRepository repository;

    @DisplayName("保存功能")
    @Nested
    class Save {
        @DisplayName("保存成功")
        @Test
        void save_success() {
            Function function = createFunction();

            repository.save(function);
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

}