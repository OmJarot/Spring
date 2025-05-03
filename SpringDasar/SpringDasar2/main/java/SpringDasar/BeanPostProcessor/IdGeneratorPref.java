package SpringDasar.BeanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGeneratorPref implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {//akan dijalankan setelah order 1
        return 2;
    }

    @Override//akan di eksekusi setiap bean telah selesai di initial
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Id generator Processor 2");
        if (bean instanceof IdAware){
            log.info("Set id generator for {}", beanName);
            IdAware obj = (IdAware) bean;
            obj.setId("PPG"+obj.getId());
        }
        return bean;
    }
}
