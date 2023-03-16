package com.wyyl1.pm.adapter.in.restful.proj.function.status;

import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo.FunctionStatusVo;
import com.wyyl1.pm.domain.proj.function.FunctionStatusEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FunctionStatusToolsTest {

    @DisplayName("获得所有功能状态")
    @Nested
    class AllStatus {

        @DisplayName("数量于 FunctionStatusEnum 的 values 相同")
        @Test
        void count_is_same_as_FunctionStatusEnum_values() {
            List<FunctionStatusVo> allStatus = FunctionStatusTools.allStatus();

            assertThat(allStatus.size()).isEqualTo(FunctionStatusEnum.values().length);
        }

        @DisplayName("status、name 和 FunctionStatusEnum 中是一样的")
        @Test
        void status_name_is_same_as_FunctionStatusEnum() {
            List<FunctionStatusVo> allStatus = FunctionStatusTools.allStatus();

            for (FunctionStatusVo functionStatusVo : allStatus) {
                FunctionStatusEnum functionStatusEnum = FunctionStatusEnum.of(functionStatusVo.getStatus());

                assertThat(functionStatusVo.getName()).isEqualTo(functionStatusEnum.getName());
            }
        }
    }
}