package spring_dasar.Data.LifeCycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {//tanpa implements

    public void start(){
        log.info("Start");
    }

    public void stop(){
        log.info("Stop");
    }

}
