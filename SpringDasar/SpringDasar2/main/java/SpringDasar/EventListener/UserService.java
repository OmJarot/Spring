package SpringDasar.EventListener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password){
        if (isValid(username, password)){
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));//jika berhasil akan kirim sinyal ke event
            return true;
        }
        return false;
    }

    private boolean isValid(String username, String password){
        if ("piter".equals(username) && "piter".equals(password)){
            return true;
        }
        return false;
    }
}
