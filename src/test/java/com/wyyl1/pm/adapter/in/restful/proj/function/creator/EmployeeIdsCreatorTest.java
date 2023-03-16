package com.wyyl1.pm.adapter.in.restful.proj.function.creator;

import com.alibaba.fastjson2.JSON;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmployeeIdsCreatorTest {

    private Map<Integer, List<Integer>> correctResults = Map.of(
            1, List.of(1),
            2, List.of(1, 2),
            3, List.of(13, 5, 6, 7, 8, 1, 2)
    );

    @DisplayName("根据不同参数返回正确的结果")
    @ParameterizedTest
    @CsvSource(value = {
            "1; [\"participantIds\":\"1\"},{\"originatorId\":1}]",
            "2; [{\"originatorId\":1,\"participantIds\":\"1,2\"},{\"originatorId\":2,\"participantIds\":\"1\"}]",
            "3; [{\"originatorId\":5,\"participantIds\":\"1,2\"},{\"originatorId\":8,\"participantIds\":\"8,7,6,5\"},{\"originatorId\":13,\"participantIds\":\",13,6,7,1\"}]"
    }, delimiter = ';')
    void return_correct_result_when_input_different_parameters(Integer key, String jsonArray) {
        List<Function> functions = JSON.parseArray(jsonArray, Function.class);

        List<Integer> employeeIds = EmployeeIdsCreator.allNoDuplicateIds(functions);

        List<Integer> expectedEmployeeIds = correctResults.get(key);

        assertThat(employeeIds.size()).isEqualTo(expectedEmployeeIds.size());

        for (Integer employeeId : employeeIds) {
            assertThat(expectedEmployeeIds.contains(employeeId)).isTrue();
        }
    }

    private static Function createFunction(Integer originatorId, String participantIds) {
        return Function.builder()
                .originatorId(originatorId)
                .participantIds(participantIds)
                .build();
    }

}