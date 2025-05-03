package SpringBootDasar.Component.Qualifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Component.Qualifier.Computer;
import spring_dasar.Configuration.Component.Qualifier.Cpu;
import spring_dasar.Configuration.Component.Qualifier.QualifierConfiguration;

public class QualifierTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(QualifierConfiguration.class);
    }

    @Test
    void testQualifier() {
        Computer computer = context.getBean(Computer.class);

        Cpu cpu1 = context.getBean("cpu1", Cpu.class);
        Cpu cpu2 = context.getBean("cpu2", Cpu.class);

        Assertions.assertSame(cpu1, computer.getCpu1());
        Assertions.assertSame(cpu2, computer.getCpu2());
    }
}
