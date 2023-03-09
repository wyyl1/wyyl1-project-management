package com.wyyl1.pm.common.page;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PageTest {

    @DisplayName("根据 pageNum、pageSize、recordTotal计算出正确的 offset、rowCount")
    @ParameterizedTest
    @CsvSource({
            "1, 10, 0, 0, 0",
            "1, 10, 1, 0, 1",
            "1, 10, 10, 0, 10",
            "1, 10, 11, 0, 10",
            "2, 10, 0, 0, 0",
            "2, 10, 1, 0, 0",
            "2, 10, 10, 0, 0",
            "2, 10, 11, 10, 1",
            "2, 10, 20, 10, 10",
            "2, 10, 21, 10, 10",
            "3, 10, 0, 0, 0",
            "3, 10, 1, 0, 0",
            "3, 10, 10, 0, 0",
            "3, 10, 11, 10, 0",
            "3, 10, 20, 10, 0",
            "3, 10, 21, 20, 1",
            "3, 10, 30, 20, 10",
            "3, 10, 31, 20, 10",
    })
    void offsetAndRowCount(int pageNum, int pageSize, int recordTotal, int offset, int rowCount) {
        Page page = Page.of(pageNum, pageSize, recordTotal);

        assertThat(page.offset()).isEqualTo(offset);
        assertThat(page.rowCount()).isEqualTo(rowCount);
    }
}