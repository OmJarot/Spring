package FileRolling;

import FileOutput.FileOutputTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(classes ={
        FileRollingTest.class
})
@TestPropertySource("classpath:application-test.properties")
public class FileRollingTest {

    @Test
    void testFileRolling() {
        for (int i = 0; i < 100_000; i++) {
            log.warn("Hello world {}",i);
        }
    }
}
