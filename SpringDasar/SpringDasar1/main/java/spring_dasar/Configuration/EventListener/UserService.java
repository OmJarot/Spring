package spring_dasar.Configuration.EventListener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {
    //publisher

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {//otomatis di inject
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //pertama-tama login
    public boolean login(String username, String password){//login
        if (isLoginSuccess(username,password)){//cek apakah login valid, jika ya
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));//maka akan di publish, akan di kirim ke event
            return true;
        }else {
            return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {//cek login
        return "piter".equals(username) && "piter".equals(password);
    }
}
