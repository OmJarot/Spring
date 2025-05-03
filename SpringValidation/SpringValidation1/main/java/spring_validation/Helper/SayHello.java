package spring_validation.Helper;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated//otomatis mengecek semua validation di method, nanti akan membalikan throw excpetion
public class SayHello {

    public String sayHello(@NotBlank String name){
        return "Hello "+name;
    }

}
