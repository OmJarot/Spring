package SpringDasar.EventListenerAnnotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedeemListener {

    @EventListener(classes = RedeemEvent.class)
    public void loginSuccess(RedeemEvent event){
        log.info("Success redeem with id {}", event.getRedeem());
    }

}
