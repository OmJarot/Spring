package SpringBootDasar.Component.ComponentDependencyInjection.FieldsComponentDependencyInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency.ComponentDependencyConfig;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.FieldComponentDependencyInjection.City;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.FieldComponentDependencyInjection.Country;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.FieldComponentDependencyInjection.FieldConfiguration;

public class FieldsTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FieldConfiguration.class);
    }

    @Test
    void testField() {
        City city = context.getBean(City.class);
        Country country = context.getBean(Country.class);

        Assertions.assertSame(country, city.getCountry());
    }
}
