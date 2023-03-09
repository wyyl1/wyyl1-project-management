package com.wyyl1.pm.adapter.out.persistence.proj.function;

import com.wyyl1.pm.adapter.out.persistence.proj.function.entity.FunctionEntity;
import com.wyyl1.pm.adapter.out.persistence.proj.function.mapper.FunctionMapper;
import com.wyyl1.pm.adapter.out.persistence.proj.function.wrapper.FunctionQuery;
import com.wyyl1.pm.common.page.Page;
import com.wyyl1.pm.common.page.PageQuery;
import com.wyyl1.pm.common.util.AssertUtils;
import com.wyyl1.pm.common.util.JsonFormatter;
import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import com.wyyl1.pm.domain.proj.function.pojo.query.FunctionListQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class FunctionRepositoryImpl implements FunctionRepository {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public void save(Function function) {
        FunctionEntity entity = new FunctionEntity();
        BeanUtils.copyProperties(function, entity);
        entity.setId(null);

        AssertUtils.isTrue(functionMapper.insert(entity) == 1, () -> "保存功能失败 " + JsonFormatter.beautify(function));
    }

    @Override
    public Page<Function> page(FunctionListQuery listQuery, PageQuery pageQuery) {
        FunctionQuery query = createCommonQuery(listQuery);

        Page<Function> page = Page.of(pageQuery, query.to().count());

        List<FunctionEntity> entities = selectList(query, page);
        List<Function> list = listOf(entities);
        page.dataList(list);

        return page;
    }

    private static FunctionQuery createCommonQuery(FunctionListQuery listQuery) {
        FunctionQuery query = FunctionQuery.query();
        if (listQuery == null) {
            return query;
        }

        if (listQuery.getPlatformId() != null) {
            query.where().platformId().eq(listQuery.getPlatformId());
        }
        return query;
    }

    private static List<FunctionEntity> selectList(FunctionQuery query, Page<Function> page) {
        return query.orderBy().createAt().desc().end()
                .limit(page.offset(), page.rowCount())
                .to().listEntity();
    }

    private static List<Function> listOf(List<FunctionEntity> entities) {
        return entities.stream().map(entity -> {
            Function function = new Function();
            BeanUtils.copyProperties(entity, function);
            return function;
        }).toList();
    }
}
