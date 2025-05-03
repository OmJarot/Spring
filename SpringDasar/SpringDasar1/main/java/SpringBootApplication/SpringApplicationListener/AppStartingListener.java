package SpringBootApplication.SpringApplicationListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppStartingListener implements ApplicationListener<ApplicationStartingEvent> {
    // ApplicationStartingEvent: Dikirim ketika start aplikasi
    //ApplicationContextInitializedEvent : Dikirim ketika ApplicationContext sudah di initialisasi
    //ApplicationStartedEvent: Dikirim ketika aplikasi sudah berjalan
    //ApplicationFailedEvent: Dikirim ketika aplikasi gagal berjalan
    //dan lain-lain

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {//akan dijalankan ketika apllikasi start
        log.info("Application Starting");
    }



}
