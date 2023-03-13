package com.wyyl1.pm.domain.org.employee;

import com.wyyl1.pm.domain.org.employee.dto.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeRepository {

    Map<Integer, Employee> employeesFor(Collection<Integer> ids);
}
