package spring_dasar.Configuration.EventListenerAnnotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedeemListener {

    @EventListener(RedeemEvent.class)//menggunakan annotation sebagai listeber, kelbihannya bisa membuat lebih dari 1 listener
    public void onRedeemSuccessEvent(RedeemEvent event){
        log.info("Success redeem {} " + event.getRedeem());
    }
}
