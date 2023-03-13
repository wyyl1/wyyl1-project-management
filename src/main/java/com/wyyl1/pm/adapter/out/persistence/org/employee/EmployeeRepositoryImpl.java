package com.wyyl1.pm.adapter.out.persistence.org.employee;

import com.wyyl1.pm.adapter.out.persistence.org.employee.entity.EmployeeEntity;
import com.wyyl1.pm.adapter.out.persistence.org.employee.wrapper.EmployeeQuery;
import com.wyyl1.pm.domain.org.employee.EmployeeRepository;
import com.wyyl1.pm.domain.org.employee.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Map<Integer, Employee> employeesFor(Collection<Integer> ids) {
        return EmployeeQuery.query().selectAll()
                .where().id().in(ids.stream().distinct().toList()).end().to().listEntity().stream()
                .map(this::createEmployee)
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }

    private Employee createEmployee(EmployeeEntity entity) {
        return Employee.builder().id(entity.getId())
                .nickname(entity.getNickname())
                .departmentId(entity.getDepartmentId())
                .build();
    }
}
