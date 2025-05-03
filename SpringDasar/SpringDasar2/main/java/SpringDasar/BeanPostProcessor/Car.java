package SpringDasar.BeanPostProcessor;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware{
    @Getter
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
