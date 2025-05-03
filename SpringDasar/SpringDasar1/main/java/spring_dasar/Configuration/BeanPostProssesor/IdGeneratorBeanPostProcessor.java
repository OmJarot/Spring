package spring_dasar.Configuration.BeanPostProssesor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {//akan dijalankan setiap bean selesai dibuat
        log.info("Id Generator Prossesor for Bean "+ beanName);
        if (bean instanceof IdAware){//cek semua bean, jika bean tersebut instance of idAware maka
            log.info("Set id generator for bean  {}",beanName);
            IdAware idAware = (IdAware) bean;//konversi object menjadi idAware
            idAware.setId(UUID.randomUUID().toString());//set id menggunakan uuid
        }
        return bean;
    }

    //dijalankan sebelum bean dibuat
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
//    }
}
