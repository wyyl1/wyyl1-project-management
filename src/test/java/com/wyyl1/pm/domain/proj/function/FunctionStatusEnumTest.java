package com.wyyl1.pm.domain.proj.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FunctionStatusEnumTest {

    @DisplayName("没有重复的 status")
    @Test
    void no_duplicate_status() {
        int distinctStatusCount = (int)Arrays.stream(FunctionStatusEnum.values())
                .map(FunctionStatusEnum::getStatus)
                .distinct()
                .count();

        assertThat(distinctStatusCount).isEqualTo(FunctionStatusEnum.values().length);
    }
}