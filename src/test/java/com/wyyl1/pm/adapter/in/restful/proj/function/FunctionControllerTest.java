package com.wyyl1.pm.adapter.in.restful.proj.function;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.wyyl1.pm.adapter.in.restful.common.RestfulPage;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.form.FunctionSaveForm;
import com.wyyl1.pm.adapter.in.restful.proj.function.pojo.query.FunctionPageQuery;
import com.wyyl1.pm.adapter.out.persistence.proj.function.FunctionCleaner;
import com.wyyl1.pm.adapter.out.persistence.proj.function.mapper.FunctionMapper;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.web.servlet.MvcResult;
import test.BaseTest;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FunctionControllerTest extends BaseTest {

    @Resource
    private FunctionMapper mapper;

    @DisplayName("保存功能")
    @Nested
    class Save {
        private final String path = "/function/save/";

        @DisplayName("保存成功")
        @Test
        void save_success() throws Exception {
            mockMvc.perform(postForJson(path, createForm()))
                    .andDo(print()).andExpect(status().isOk())
                    .andReturn();

            FunctionCleaner.of(mapper).cleanLastInsert();
        }

        private FunctionSaveForm createForm() {
            FunctionSaveForm form = new FunctionSaveForm();
            form.setName("开门");
            form.setDocumentLink("https://www.deepl.com/");
            form.setOriginatorId(1);
            form.setParticipantIds("1,2,3");
            form.setPlatformId(1);
            form.setDepartmentId(1);
            form.setPlannedTestDate(20230101);
            form.setActualTestDate(20230302);
            form.setPlannedReleaseDate(20230303);
            form.setActualReleaseDate(20230304);
            form.setStatus(1);
            form.setRemark("测试");

            return form;
        }
    }

    @DisplayName("分页查询功能")
    @Nested
    class PageTest {
        private final String path = "/function/page";

        @DisplayName("没有查询条件返回成功")
        @Test
        void return_success_when_no_query_condition() throws Exception {
            FunctionPageQuery pageQuery = new FunctionPageQuery();
            pageQuery.setPageNum(1);
            pageQuery.setPageSize(10);

            String sendUrl = path + "?pageNum=" + pageQuery.getPageNum() + "&pageSize=" + pageQuery.getPageSize() + "";
            MvcResult result = mockMvc.perform(getFor(sendUrl))
                    .andDo(print()).andExpect(status().isOk())
                    .andReturn();

            RestfulPage<JSONObject> page = JSON.parseObject(result.getResponse().getContentAsString(), RestfulPage.class);

            assertThat(page.getPageTotal()).isEqualTo(1);
            assertThat(page.getRecordTotal()).isEqualTo(9);
            assertThat(page.getDataList().size()).isEqualTo(9);

            for (JSONObject json : page.getDataList()) {
                Function function = JSON.parseObject(json.toString(), Function.class);
                assertThat(function.getId()).isNotNull();
                assertThat(function.getName()).isNotBlank();
            }
        }

        @DisplayName("使用 platformId 查询返回正常数据")
        @ParameterizedTest
        @CsvSource({
                "2, 2",
                "3, 1",
                "1, 6",
        })
        void return_success_when_use_platformId(Integer platformId, Integer expectSize) throws Exception {
            FunctionPageQuery pageQuery = new FunctionPageQuery();
            pageQuery.setPageNum(1);
            pageQuery.setPageSize(10);
            pageQuery.setPlatformId(platformId);

            String sendUrl = path + "?pageNum=" + pageQuery.getPageNum() + "&pageSize=" + pageQuery.getPageSize() + "&platformId=" + pageQuery.getPlatformId();
            MvcResult result = mockMvc.perform(getFor(sendUrl))
                    .andDo(print()).andExpect(status().isOk())
                    .andReturn();

            RestfulPage<JSONObject> page = JSON.parseObject(result.getResponse().getContentAsString(), RestfulPage.class);

            assertThat(page.getPageTotal()).isEqualTo(1);
            assertThat(page.getRecordTotal()).isEqualTo(expectSize);
            assertThat(page.getDataList().size()).isEqualTo(expectSize);

            for (JSONObject json : page.getDataList()) {
                Function function = JSON.parseObject(json.toString(), Function.class);
                assertThat(function.getId()).isNotNull();
                assertThat(function.getName()).isNotBlank();
                assertThat(function.getPlatformId()).isEqualTo(platformId);
            }
        }

        @DisplayName("使用无效的 pageNum 查询返回错误提示")
        @ParameterizedTest
        @CsvSource({
                "0, 页码最小值为 1",
                "-1, 页码最小值为 1",
                "-82, 页码最小值为 1",
                "82, 无效的页码：82",
                "96, 无效的页码：96",
        })
        void return_error_when_invalid_pageNum(Integer pageNum, String errMsg) throws Exception {
            FunctionPageQuery pageQuery = new FunctionPageQuery();
            pageQuery.setPageNum(pageNum);
            pageQuery.setPageSize(10);

            String sendUrl = path + "?pageNum=" + pageQuery.getPageNum() + "&pageSize=" + pageQuery.getPageSize();
            mockMvc.perform(getFor(sendUrl))
                    .andDo(print()).andExpect(status().isBadRequest())
                    .andExpect(content().string(errMsg));
        }

        @DisplayName("使用无效的 pageSize 查询返回错误提示")
        @ParameterizedTest
        @CsvSource({
                "0, 每页最小显示数量为 1",
                "-1, 每页最小显示数量为 1",
                "-82, 每页最小显示数量为 1",
                "101, 每页最大显示数量为 100",
                "962, 每页最大显示数量为 100",
        })
        void return_error_when_invalid_pageSize(Integer pageSize, String errMsg) throws Exception {
            FunctionPageQuery pageQuery = new FunctionPageQuery();
            pageQuery.setPageNum(1);
            pageQuery.setPageSize(pageSize);

            String sendUrl = path + "?pageNum=" + pageQuery.getPageNum() + "&pageSize=" + pageQuery.getPageSize();
            mockMvc.perform(getFor(sendUrl))
                    .andDo(print()).andExpect(status().isBadRequest())
                    .andExpect(content().string(errMsg));
        }
    }

}