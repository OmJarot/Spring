package spring_dasar.Configuration.EventListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginSuccessListener implements ApplicationListener<LoginSuccessEvent> {//listener
    //isinya mendengarkan semua login success event
    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {//jika ada yang succes login maka/ jika data event ada
        log.info("Success login for user {}", event.getUser());
    }

}
