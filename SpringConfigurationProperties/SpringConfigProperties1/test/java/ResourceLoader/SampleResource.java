package ResourceLoader;

import lombok.Setter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SampleResource implements ResourceLoaderAware {//bisa menggunakan application context atau resourceLoaderAware

    @Setter
    private ResourceLoader resourceLoader;

    public String getText() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
        try (InputStream inputStream = resource.getInputStream()){
            return new String(inputStream.readAllBytes());
        }
    }

    // classpath:
    //classpath:/com/pzn/application.SpringConfig.properties
    //Mengambil resource dari classpath (isi project)

    //file
    //file:///Users/khannedy/file.SpringConfig.properties
    //Mengambil resource dari file system

    //https:
    //https://www.programmerzamannow/file.properties
    //Mengambil resource dari http

}
