package spring_dasar.Configuration.BeanPostProssesor.Ordered;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import spring_dasar.Configuration.BeanPostProssesor.IdAware;

import java.util.UUID;

@Slf4j
public class OrderedBeanPostProcessor implements BeanPostProcessor, Ordered {//membuat urutan bean post processor saat di eksekusi

    @Override//set urutan, akan di eksekusi setalah urutan 1(mulai dari yang terkeci)
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {//akan dijalankan setiap bean selesai dibuat
        log.info("Id Generator Prossesor for Bean "+ beanName);
        if (bean instanceof IdAware){//cek semua bean, jika bean tersebut instance of idAware maka
            log.info("Set id generator for bean  {}",beanName);
            IdAware idAware = (IdAware) bean;//konversi object menjadi idAware
            idAware.setId("PPG-"+idAware.getId());//set id menggunakan uuid
        }
        return bean;
    }
}
