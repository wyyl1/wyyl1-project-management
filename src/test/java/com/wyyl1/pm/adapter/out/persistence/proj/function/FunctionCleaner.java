package com.wyyl1.pm.adapter.out.persistence.proj.function;

import com.wyyl1.pm.adapter.out.persistence.proj.function.mapper.FunctionMapper;
import com.wyyl1.pm.adapter.out.persistence.proj.function.wrapper.FunctionQuery;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FunctionCleaner {

    private FunctionMapper mapper;

    public static FunctionCleaner of(FunctionMapper mapper) {
        return new FunctionCleaner(mapper);
    }

    public void cleanLastInsert() {
        Integer lastId = FunctionQuery.query().orderBy().id().desc().end().limit(1).to().findOne().get().getId();
        mapper.deleteById(lastId);
    }
}
