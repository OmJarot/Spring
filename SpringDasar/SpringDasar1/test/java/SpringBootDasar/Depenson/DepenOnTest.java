package SpringBootDasar.Depenson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.DepensOn.DepensOnConfiguration;

public class DepenOnTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DepensOnConfiguration.class);
    }

    @Test//jalankan untuk buat
    void testDepenOn() {//cek urutan bean nya dibuat


    }
}
