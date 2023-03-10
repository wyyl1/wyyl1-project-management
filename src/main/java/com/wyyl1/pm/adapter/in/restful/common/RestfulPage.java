package com.wyyl1.pm.adapter.in.restful.common;

import com.wyyl1.pm.common.page.Page;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RestfulPage<T> {

    private int pageNum; //当前页码
    private int pageSize; //每页显示的记录数
    private int recordTotal; //总记录数
    private int pageTotal; //总页数
    private List<T> dataList; //当前页的数据列表

    public static final RestfulPage of(Page page) {
        return RestfulPage.builder()
                .pageNum(page.pageNum())
                .pageSize(page.pageSize())
                .recordTotal(page.recordTotal())
                .pageTotal(page.pageTotal())
                .dataList(page.dataList())
                .build();
    }
}
