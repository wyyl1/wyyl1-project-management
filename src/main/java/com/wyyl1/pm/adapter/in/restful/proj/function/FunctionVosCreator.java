package com.wyyl1.pm.adapter.in.restful.proj.function;

import com.wyyl1.pm.common.util.ListUtils;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class FunctionVosCreator {

    private List<Function> functions;

    private List<Integer> allEmployeeIds() {
        return null;
    }

    private List<Integer> allOriginatorIds(){
        return functions.stream()
                .map(Function::getOriginatorId).toList();
    }

    private List<Integer> allParticipantIds(){
        return functions.stream()
                .map(f -> ListUtils.integersFor(f.getParticipantIds()))
                .flatMap(Collection::stream)
                .toList();
    }


}
