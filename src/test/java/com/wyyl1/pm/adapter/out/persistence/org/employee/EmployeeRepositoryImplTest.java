package com.wyyl1.pm.adapter.out.persistence.org.employee;

import com.alibaba.fastjson2.JSON;
import com.wyyl1.pm.domain.org.employee.EmployeeRepository;
import com.wyyl1.pm.domain.org.employee.dto.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.BaseTest;

import javax.annotation.Resource;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmployeeRepositoryImplTest extends BaseTest {

    @Resource
    private EmployeeRepository repository;

    @DisplayName("根据员工id集合查询对应的员工信息")
    @Nested
    class EmployeesFor {

        Map<Integer, Employee> employeesForDB = Map.of(
                1, createEmployee(1, "苹果", 1),
                2, createEmployee(2, "葡萄", 1),
                3, createEmployee(3, "草莓", 2),
                4, createEmployee(4, "荔枝", 2),
                5, createEmployee(5, "香蕉", 2),
                6, createEmployee(6, "菠萝", 3),
                7, createEmployee(7, "樱桃", 3),
                8, createEmployee(8, "枇杷", 3),
                9, createEmployee(9, "椰子", 3)
        );

        private Employee createEmployee(int id, String 苹果, int departmentId) {
            return Employee.builder().id(id).nickname(苹果).departmentId(departmentId).build();
        }

        @DisplayName("使用没有重复的正确id集合获得正确的员工信息")
        @ParameterizedTest
        @CsvSource(value = {
                "3;[1,2,3]",
                "9;[1,2,3,4,5,6,7,8,9]"
        }, delimiter = ';')
        void return_correct_employees_when_using_the_correct_ids_with_no_duplicates(int expectedSize, String idsJsonArray) {
            Map<Integer, Employee> employees = repository.employeesFor(JSON.parseArray(idsJsonArray).toJavaList(Integer.class));

            assertThat(employees.size()).isEqualTo(expectedSize);

            employees.forEach((id, employee) -> assertThat(employee).isEqualTo(employeesForDB.get(id)));
        }

        @DisplayName("使用有重的正确id集合获得正确的员工信息")
        @ParameterizedTest
        @CsvSource(value = {
                "3;[1,2,3,1,2,3]",
                "3;[1,2,3,1,2,3,2,3,1,2,3,3,3,1]",
                "9;[1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9]"
        }, delimiter = ';')
        void return_correct_employees_when_using_the_correct_ids_with_duplicates(int expectedSize, String idsJsonArray) {
            Map<Integer, Employee> employees = repository.employeesFor(JSON.parseArray(idsJsonArray).toJavaList(Integer.class));

            assertThat(employees.size()).isEqualTo(expectedSize);

            employees.forEach((id, employee) -> assertThat(employee).isEqualTo(employeesForDB.get(id)));
        }

        @DisplayName("id集合中包含无效的id时，只返回有效的员工信息")
        @ParameterizedTest
        @CsvSource(value = {
                "3;[1,2,3,10,20]",
                "9;[1,2,3,4,5,6,7,8,9,11,32]"
        }, delimiter = ';')
        void return_correct_employees_when_using_the_ids_contains_invalid_ids(int expectedSize, String idsJsonArray) {
            Map<Integer, Employee> employees = repository.employeesFor(JSON.parseArray(idsJsonArray).toJavaList(Integer.class));

            assertThat(employees.size()).isEqualTo(expectedSize);

            employees.forEach((id, employee) -> assertThat(employee).isEqualTo(employeesForDB.get(id)));
        }

    }

}