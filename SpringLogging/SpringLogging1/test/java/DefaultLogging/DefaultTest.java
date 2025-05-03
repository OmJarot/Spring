package DefaultLogging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = {
        DefaultTest.class
})
public class DefaultTest {

    @Test
    void testDefault() {
        log.info("Belajar Java");
        log.warn("Belajar Spring logging");
        log.error("Belajar Piter");
    }
}
