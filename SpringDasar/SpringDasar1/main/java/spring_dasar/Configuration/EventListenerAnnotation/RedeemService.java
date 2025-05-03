package spring_dasar.Configuration.EventListenerAnnotation;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RedeemService {

    private ApplicationEventPublisher publisher;

    public RedeemService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public boolean redeem(String id){
        if (isValid(id)){
            publisher.publishEvent(new RedeemEvent(new Redeem(id)));
            return true;
        }else {
            return false;
        }
    }

    public boolean isValid(String id){
        return "123".equals(id);
    }
}
