package SpringDasar.LifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {//otomatis dijalankan saat bean sudah siap
        log.info("Connection ready to use");
    }

    @Override
    public void destroy() throws Exception {//di jalankan ketika aplikasi dimatikan
        log.info("Connection Destroy");
    }
}
