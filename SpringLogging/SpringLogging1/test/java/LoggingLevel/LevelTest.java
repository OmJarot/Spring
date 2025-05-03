package LoggingLevel;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(classes = LevelTest.class)
@TestPropertySource("classpath:application-test.properties")//set level log di package
public class LevelTest {
//di package ini yang muncul hanya level warn ke-atas
    @Test
    void testLevel() {
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
