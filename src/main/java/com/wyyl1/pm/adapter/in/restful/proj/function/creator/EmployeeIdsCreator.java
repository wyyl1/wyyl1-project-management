package com.wyyl1.pm.adapter.in.restful.proj.function.creator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.wyyl1.pm.common.util.ListUtils;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class EmployeeIdsCreator {

    static final List<Integer> allNoDuplicateIds(final List<Function> functions) {
        List<Integer> allOriginatorIds = allOriginatorIds(functions);
        List<Integer> allParticipantIds = allParticipantIds(functions);

        return Lists.newArrayList(Iterables.concat(allOriginatorIds, allParticipantIds))
                .stream().filter(Objects::nonNull).distinct().toList();
    }

    private static List<Integer> allOriginatorIds(List<Function> functions){
        return functions.stream()
                .map(Function::getOriginatorId).toList();
    }

    private static List<Integer> allParticipantIds(List<Function> functions){
        return functions.stream()
                .map(f -> allParticipantIds(f))
                .flatMap(Collection::stream)
                .toList();
    }

    static List<Integer> allParticipantIds(Function f) {
        return ListUtils.integersFor(f.getParticipantIds()).stream().filter(Objects::nonNull).distinct().toList();
    }
}
