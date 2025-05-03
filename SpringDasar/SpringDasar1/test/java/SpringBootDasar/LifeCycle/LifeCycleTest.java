package SpringBootDasar.LifeCycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.LifeCycle.ConnectionConfiguration;
import spring_dasar.Data.LifeCycle.Connection;

public class LifeCycleTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ConnectionConfiguration.class);//memulai bean
        context.registerShutdownHook();//otomatis saat di shudown
    }

    @AfterEach
    void tearDown() {
        //menutup aplikasi, akan memanggil destroy
//        context.close();//manual
    }

    @Test
    void testLifeCycle() {
        Connection connection = context.getBean(Connection.class);
    }
}
