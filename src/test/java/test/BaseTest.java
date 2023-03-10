package test;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BaseTest {

    @Autowired
    protected MockMvc mockMvc;

    @LocalServerPort
    private int port;

    protected MockHttpServletRequestBuilder postForJson(String path, Object form) {
        return post(getUrl(path))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(form));
    }

    protected MockHttpServletRequestBuilder getFor(String path) {
        return get(getUrl(path))
                .contentType(MediaType.ALL_VALUE);
    }

    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}
