package LogPattern;

import LogGroup.LogGroupTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(classes = {
        LogPatternTest.class
})
@TestPropertySource("classpath:application-test.properties")
public class LogPatternTest {

    @Test
    void testPattern() {
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
