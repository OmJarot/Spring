package spring_dasar.Data.LifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {//method ini akan dipanggil saat bean telah siap
        log.info("Connection is ready");
    }

    @Override
    public void destroy() throws Exception {//method ini akan dipanggil saat aplikasi mati, atau saat dishutdown
        log.info("Connection is Closed");
    }
}
