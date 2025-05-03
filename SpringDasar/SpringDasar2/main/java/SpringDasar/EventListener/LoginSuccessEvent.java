package SpringDasar.EventListener;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class LoginSuccessEvent extends ApplicationEvent {
    //menyimpan data login yang success
    @Getter
    private final User user;

    public LoginSuccessEvent(User user) {//jika datanya ada maka listener akan menjalankan methodnya
        super(user);
        this.user = user;
    }
}
