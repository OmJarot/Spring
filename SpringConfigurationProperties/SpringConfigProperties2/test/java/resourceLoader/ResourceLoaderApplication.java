package resourceLoader;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class ResourceLoaderApplication {
    @Component
    public static class SampleLoader implements ResourceLoaderAware{

        @Setter
        private ResourceLoader resourceLoader;

        public String getText() throws IOException {
            Resource text = resourceLoader.getResource("classpath:/text/resource.txt");
            try (InputStream inputStream = text.getInputStream()) {
                return new String(inputStream.readAllBytes());
            }
        }
    }

}
