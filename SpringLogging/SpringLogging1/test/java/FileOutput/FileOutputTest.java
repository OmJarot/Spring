package FileOutput;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest(classes ={
        FileOutputTest.class
})
@TestPropertySource("classpath:application-test.properties")
public class FileOutputTest {
//log akan dikirim juga ke file
    @Test
    void testFileOutput() {
        log.info("bejalar java");
        log.info("belajar logging");
        log.info("belajar");
    }
}
