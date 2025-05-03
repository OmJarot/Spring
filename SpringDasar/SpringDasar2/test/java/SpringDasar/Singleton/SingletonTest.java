package SpringDasar.Singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    void testSingleton() {
        Database instance1 = Database.getInstance();
        Database instance2 = Database.getInstance();

        Assertions.assertSame(instance1, instance2);
    }
}
