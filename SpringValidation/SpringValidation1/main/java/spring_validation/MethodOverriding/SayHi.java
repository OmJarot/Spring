package spring_validation.MethodOverriding;

import org.springframework.stereotype.Component;

@Component
public class SayHi implements ISayHi{
    @Override
    public String sayHi(String name) {
        return "";
    }
}
