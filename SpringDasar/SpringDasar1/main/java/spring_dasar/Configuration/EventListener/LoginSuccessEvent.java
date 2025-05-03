package spring_dasar.Configuration.EventListener;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class LoginSuccessEvent extends ApplicationEvent {//event
    //data event ini adalah data yang sukses login
    @Getter
    private User user;

    public LoginSuccessEvent(User user){
        super(user);
        this.user = user;
    }

}
