package SpringConfig.Converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {//contoh membuat converter dari String ke Date
    //jika ingin membuat convorter sendiri
    //akan otomatis dibaca oleh spring saat dibuat menjadi bean

    private SimpleDateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd");

    @SneakyThrows
    @Override
    public Date convert(String source) {
        return DATE_FORMAT.parse(source);
    }


}
