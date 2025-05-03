package SpringDasar.BeanPostProcessor;

import org.springframework.stereotype.Component;

public interface IdAware {

    void setId(String id);

    String getId();

}
