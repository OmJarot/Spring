package spring_dasar.Configuration.Component.Qualifier;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    @Getter
    private Cpu cpu1;

    @Getter
    private Cpu cpu2;

    public Computer(@Qualifier("cpu1") Cpu cpu1, @Qualifier("cpu2")Cpu cpu2) {
        this.cpu1 = cpu1;
        this.cpu2 = cpu2;
    }
}
