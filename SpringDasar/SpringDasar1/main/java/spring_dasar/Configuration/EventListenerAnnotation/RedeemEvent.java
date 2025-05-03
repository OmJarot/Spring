package spring_dasar.Configuration.EventListenerAnnotation;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class RedeemEvent extends ApplicationEvent {

    @Getter
    private Redeem redeem;

    public RedeemEvent(Redeem redeem){
        super(redeem);
        this.redeem = redeem;
    }

}
