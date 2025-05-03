package SpringBootApplication.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class LogCommand implements CommandLineRunner {

    @Override//method ini akan otomatis dijalankan saat aplikasi start
    public void run(String... args) throws Exception {//parameternya akan otomatis mengambil parameter argument yang ada di main methodnya
        log.info("Log Command line runner {}", Arrays.toString(args));
    }
}
