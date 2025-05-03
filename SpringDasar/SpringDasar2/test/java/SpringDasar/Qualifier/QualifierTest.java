package SpringDasar.Qualifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierTest {
    @Test
    void testQualifier() {
        ApplicationContext context = new AnnotationConfigApplicationContext(QualifierConfig.class);

        CountryService countryService = context.getBean(CountryService.class);

        CountryRepository countryRepository1 = context.getBean("countryRepository1", CountryRepository.class);
        CountryRepository countryRepository2 = context.getBean("countryRepository2", CountryRepository.class);

        Assertions.assertSame(countryRepository1, countryService.getCountryRepository1());
        Assertions.assertSame(countryRepository2, countryService.getCountryRepository2());
        Assertions.assertNotSame(countryRepository1,countryRepository2);

    }
}
