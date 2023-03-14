package com.wyyl1.pm.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ListUtilsTest {

    private Map<Integer, List<Integer>> correctResults = Map.of(
            1, List.of(1),
            2, List.of(1, 2),
            3, List.of(1, 2, 1, 13, 5, 5, 6, 7, 8, 1, 2, 5)
    );

    @DisplayName("输入用,分割的数字字符串返回正确的结果")
    @ParameterizedTest
    @CsvSource(value = {
            "1;1",
            "2;1,2",
            "3;1,2,1,13,5,5,6,7,8,1,2,5",
    }, delimiter = ';')
    void return_correct_result_when_enter_a_string_of_numbers_split_by_comma(Integer key, String numbersSplitByComma) {
        List<Integer> integers = ListUtils.integersFor(numbersSplitByComma);

        List<Integer> expectedIntegers = correctResults.get(key);

        assertThat(integers.size()).isEqualTo(expectedIntegers.size());

        for (int i = 0; i < integers.size(); i++) {
            assertThat(integers.get(i)).isEqualTo(expectedIntegers.get(i));
        }
    }

    @DisplayName("输入空字符串返回空列表")
    @ParameterizedTest
    @CsvSource(value = {
            "''",
            "' '",
            "'  '",
    })
    void return_empty_list_when_enter_empty_string(String numbersSplitByComma) {
        List<Integer> integers = ListUtils.integersFor(numbersSplitByComma);

        assertThat(integers.size()).isEqualTo(0);
    }

    @DisplayName("输入参数为 null 时返回空列表")
    @Test
    void return_empty_list_when_enter_null() {
        List<Integer> integers = ListUtils.integersFor(null);

        assertThat(integers.size()).isEqualTo(0);
    }
}