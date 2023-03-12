package com.wyyl1.pm.common.page;

import com.wyyl1.pm.common.util.AssertUtils;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Page<T> {

    private int pageNum; //当前页码
    private int pageSize; //每页显示的记录数
    private int recordTotal; //总记录数
    private int pageTotal; //总页数
    private int offset; //开始索引（用于数据库查询）
    private int rowCount; //结束索引（用于数据库查询）
    private List<T> dataList; //当前页的数据列表

    private Page(final int pageNum, final int pageSize, final int recordTotal) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.recordTotal = recordTotal;
        this.dataList = List.of();
        //计算总页数和开始索引、结束索引
        if (recordTotal % pageSize == 0) {
            this.pageTotal = recordTotal / pageSize;
        } else {
            this.pageTotal = recordTotal / pageSize + 1;
        }

        AssertUtils.isTrue(validPageNum(), () -> "无效的页码：" + pageNum);

        this.offset = 0;
        this.rowCount = 0;
        if (recordTotal > 0) {
            this.offset = (this.pageNum - 1) * this.pageSize;
            this.rowCount = this.pageSize;
        }
    }

    public static <T> Page<T> of(int pageNum, int pageSize, int recordTotal) {
        return new Page<>(pageNum, pageSize, recordTotal);
    }

    public static <T> Page<T> of(PageQuery pageQuery, int recordTotal) {
        checkNotNull(pageQuery);

        return new Page<>(pageQuery.pageNum(), pageQuery.pageSize(), recordTotal);
    }

    public int pageNum() {
        return pageNum;
    }

    public int pageSize() {
        return pageSize;
    }

    public int recordTotal() {
        return recordTotal;
    }

    public int pageTotal() {
        return pageTotal;
    }

    public int offset() {
        return offset;
    }

    public int rowCount() {
        return rowCount;
    }

    public Page dataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }

    public List<T> dataList() {
        return dataList;
    }

    private boolean validPageNum() {
        if (pageNum == 1) {
            return true;
        }
        return pageNum > 0 && pageNum <= pageTotal;
    }
}
