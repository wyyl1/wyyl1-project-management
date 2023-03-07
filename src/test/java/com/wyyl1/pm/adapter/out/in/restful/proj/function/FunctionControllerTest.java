package com.wyyl1.pm.adapter.out.in.restful.proj.function;

import com.wyyl1.pm.adapter.out.in.restful.proj.function.form.FunctionSaveForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import test.BaseTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FunctionControllerTest extends BaseTest {

    @DisplayName("保存功能")
    @Nested
    class Save {
        private final String path = "/function/save/";

        @DisplayName("保存成功")
        @Test
        void save_success() throws Exception {
            MvcResult result = mockMvc.perform(postForJson(path, createForm()))
                    .andDo(print()).andExpect(status().isOk())
                    .andReturn();

            assertThat(Integer.parseInt(result.getResponse().getContentAsString())).isGreaterThan(0);
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

}