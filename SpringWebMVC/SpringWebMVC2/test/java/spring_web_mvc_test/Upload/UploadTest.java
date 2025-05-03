package spring_web_mvc_test.Upload;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testUpload() throws Exception {
        mockMvc.perform(
                multipart("/upload")
                        .file(new MockMultipartFile("file", "sample.PNG","image/png",
                                getClass().getResourceAsStream("/images/sample.PNG")))
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("name","piter")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success upload file piterto upload\\sample.PNG"))
        );
    }
}
