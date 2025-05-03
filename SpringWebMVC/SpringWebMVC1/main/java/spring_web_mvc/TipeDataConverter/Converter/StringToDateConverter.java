package spring_web_mvc.TipeDataConverter.Converter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return format.parse(source);
        }catch (ParseException e){
            log.warn("Error converter date from String {}",source);
            return null;
        }
    }
}
