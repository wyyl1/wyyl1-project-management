package com.wyyl1.pm.common.page;

/**
 * 分页查询参数
 * @param pageNum 当前页码
 * @param pageSize 每页显示的记录数
 */
public record PageQuery(int pageNum, int pageSize) {

    public static PageQuery of(int pageNum, int pageSize) {
        return new PageQuery(pageNum, pageSize);
    }
}
