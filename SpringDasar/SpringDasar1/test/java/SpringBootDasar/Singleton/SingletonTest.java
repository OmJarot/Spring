package SpringBootDasar.Singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_dasar.Singleton.Database;

public class SingletonTest {

    @Test
    void testSingleton() {
        //singleton
        //sebanyak apapun object dibuat akan mengembalikan object yang sama

        //var database = new Database(); tidak bisa karena private
        //memaksa membuat object menggunakan static method untuk membuat object
        var database1 = Database.getInstance();
        var database2 = Database.getInstance();

        Assertions.assertSame(database1,database2);//sebanyak apapun object dibuat akan mengembalikan object yang sama
    }
}
