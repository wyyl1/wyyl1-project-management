package com.wyyl1.pm.adapter.out.persistence.proj.function;

import com.wyyl1.pm.adapter.out.persistence.proj.function.entity.FunctionEntity;
import com.wyyl1.pm.adapter.out.persistence.proj.function.mapper.FunctionMapper;
import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.dto.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class FunctionRepositoryImpl implements FunctionRepository {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public Integer save(Function function) {
        FunctionEntity entity = new FunctionEntity();
        BeanUtils.copyProperties(function, entity);
        entity.setId(null);

        return functionMapper.insert(entity);
    }
}
