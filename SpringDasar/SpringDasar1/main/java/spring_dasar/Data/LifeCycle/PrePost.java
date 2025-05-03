package spring_dasar.Data.LifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrePost {
    //menggunakan annotation

    @PostConstruct//akan dijalankan setelah bean siap
    public void start(){
        log.info("start");
    }

    @PreDestroy//akan dijalankan ketika aplikasi shutdown
    public void stop(){
        log.info("stop");
    }
}
