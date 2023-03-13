package com.wyyl1.pm.domain.org.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    /**
     * 花名
     */
    private String nickname;

    /**
     * 部门id
     */
    private Integer departmentId;
}
