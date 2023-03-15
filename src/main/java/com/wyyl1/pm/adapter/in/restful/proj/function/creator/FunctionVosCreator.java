package com.wyyl1.pm.adapter.in.restful.proj.function.creator;

import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.vo.FunctionVo;
import com.wyyl1.pm.domain.org.employee.EmployeeRepository;
import com.wyyl1.pm.domain.org.employee.dto.Employee;
import com.wyyl1.pm.domain.org.platform.PlatformRepository;
import com.wyyl1.pm.domain.org.platform.dto.Platform;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

public class FunctionVosCreator {

    private final List<Function> functions;
    private final EmployeeRepository employeeRepository;
    private final PlatformRepository platformRepository;

    public FunctionVosCreator(List<Function> functions, EmployeeRepository employeeRepository, PlatformRepository platformRepository) {
        this.functions = functions;
        this.employeeRepository = employeeRepository;
        this.platformRepository = platformRepository;
    }

    private List<FunctionVo> result;

    public List<FunctionVo> of() {
        createResultForCopySameFields();
        addEmployeeNameToResult();
        addShowDocumentLinkToResult();
        addPlatformName();

        return result;
    }

    private void createResultForCopySameFields() {
        result = functions.stream()
                .map(f -> {
                    FunctionVo vo = new FunctionVo();
                    BeanUtils.copyProperties(f, vo);
                    return vo;
                }).toList();
    }

    private void addEmployeeNameToResult() {
        Map<Integer, Employee> employees = employeeRepository.employeesFor(allEmployeeIds());

        for (int i = 0; i < result.size(); i++) {
            FunctionVo vo = result.get(i);
            Function f = functions.get(i);

            vo.setOriginatorName(employees.get(f.getOriginatorId()).getNickname());

            String participantNames = createParticipantNames(employees, f);
            vo.setParticipantNames(participantNames);
        }

    }

    private static String createParticipantNames(Map<Integer, Employee> employees, Function f) {
        return EmployeeIdsCreator.allParticipantIds(f).stream()
                .map(employees::get)
                .map(Employee::getNickname)
                .reduce((a, b) -> a + "," + b).get();
    }

    private List<Integer> allEmployeeIds() {
        return EmployeeIdsCreator.allNoDuplicateIds(functions);
    }

    private void addShowDocumentLinkToResult() {
        for (FunctionVo vo : result) {
            vo.setShowDocumentLink(vo.getDocumentLink().startsWith("http"));
        }
    }

    private void addPlatformName() {
        Map<Integer, Platform> platforms = platformRepository.allPlatforms();
        for (FunctionVo vo : result) {
            vo.setPlatformName(platforms.get(vo.getPlatformId()).getName());
        }
    }

}
