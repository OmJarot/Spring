package PropertySourceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@SpringBootTest(classes = {
    TestProperty.class
})
@TestPropertySources({//meregistrasikan SpringConfig.properties, hanya untuk unit test
        @TestPropertySource("classpath:test.properties")
})
public class PropertySourceTest {
    //digunakan hanya untuk unit test saja
    //tidak perlu mendaftarkan property sourcesnya lagi di SpringBootApplication

    @Autowired
    TestProperty property;

    @Test
    void testPropertyTest() {
        Assertions.assertEquals("Sample project test",property.getName());
        Assertions.assertEquals(2,property.getVersion());
    }
}
