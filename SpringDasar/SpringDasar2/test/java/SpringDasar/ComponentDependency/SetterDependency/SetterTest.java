package SpringDasar.ComponentDependency.SetterDependency;

import SpringDasar.ComponentDependency.ComponentDependencyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterTest {
    @Test
    void testSetter() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentDependencyConfig.class);

        PersonService personService = context.getBean(PersonService.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);

        Assertions.assertNotNull(personRepository);
        Assertions.assertNotNull(personService);

        Assertions.assertSame(personRepository, personService.getPersonRepository());
    }
}
