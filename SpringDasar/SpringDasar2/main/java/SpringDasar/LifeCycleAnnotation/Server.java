package SpringDasar.LifeCycleAnnotation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {

    public void start(){
        log.info("Start Application");
    }

    public void stop(){
        log.info("Stop Application");
    }
}
