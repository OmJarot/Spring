package SpringDasar.EventListenerAnnotation;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class RedeemService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public boolean cek(String id){
        if (valid(id)){
            publisher.publishEvent(new RedeemEvent(new Redeem(id)));
            return true;
        }return false;
    }

    private boolean valid(String id) {
        return "123".equals(id);
    }
}
