package com.wyyl1.pm.common.page;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PageTest {

    @DisplayName("使用正确的 pageNum、pageSize、recordTotal计算出正确的 offset、rowCount")
    @ParameterizedTest
    @CsvSource({
            "1, 10, 1, 0, 1",
            "1, 10, 10, 0, 10",
            "1, 10, 11, 0, 10",
            "2, 10, 11, 10, 11",
            "2, 10, 20, 10, 20",
            "2, 10, 21, 10, 20",
            "3, 10, 21, 20, 21",
            "3, 10, 30, 20, 30",
            "3, 10, 31, 20, 30",
            "4, 10, 31, 30, 31",
            "4, 10, 40, 30, 40",
            "4, 10, 41, 30, 40",
            "5, 10, 41, 40, 41",
            "5, 10, 50, 40, 50",
            "5, 10, 51, 40, 50",
            "6, 10, 51, 50, 51",
            "6, 10, 60, 50, 60",
            "6, 10, 61, 50, 60",
            "7, 10, 61, 60, 61",
            "7, 10, 70, 60, 70",
            "7, 10, 71, 60, 70",
            "8, 10, 71, 70, 71",
            "8, 10, 80, 70, 80",
            "8, 10, 81, 70, 80",
            "9, 10, 81, 80, 81",
            "9, 10, 90, 80, 90",
            "9, 10, 91, 80, 90",
            "10, 10, 91, 90, 91",
            "10, 10, 100, 90, 100",
            "11, 10, 101, 100, 101",})
    void use_the_correct_pageNum_pageSize_recordTotal_to_calculate_the_correct_offset_rowCount(int pageNum, int pageSize, int recordTotal, int expectedOffset, int expectedRowCount) {
        Page page = Page.of(pageNum, pageSize, recordTotal);

        assertThat(page.offset()).isEqualTo(expectedOffset);
        assertThat(page.rowCount()).isEqualTo(expectedRowCount);
    }

    @DisplayName("使用无效页码时抛出异常")
    @ParameterizedTest
    @CsvSource({
            "0, 10, 1, 无效的页码：0",
            "10, 9875, 53, 无效的页码：10",
            "2, 10, 0, 无效的页码：2",
            "23, 10, 0, 无效的页码：23",
            "82, 9, 60, 无效的页码：82",
            "99996, 10, 9990, 无效的页码：99996",})
    void use_invalid_pageNum_throws_exception(int pageNum, int pageSize, int recordTotal, String message) {
        assertThatThrownBy(() -> Page.of(pageNum, pageSize, recordTotal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @DisplayName("无效的页码不包含第一页")
    @ParameterizedTest
    @CsvSource({
            "10, 0",
            "180, 0",
            "532, 0",
            "89, 0",
            "98, 0",
            "10000, 0",})
    void invalid_pageNum_does_not_include_the_first_page(int pageSize, int recordTotal) {
        Page<Object> page = Page.of(1, pageSize, recordTotal);

        assertThat(page.pageTotal()).isEqualTo(0);
        assertThat(page.dataList().isEmpty()).isTrue();
        assertThat(page.pageNum()).isEqualTo(1);
    }

}