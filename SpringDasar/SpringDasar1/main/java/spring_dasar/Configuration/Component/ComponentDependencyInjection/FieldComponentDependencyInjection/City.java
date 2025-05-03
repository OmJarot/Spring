package spring_dasar.Configuration.Component.ComponentDependencyInjection.FieldComponentDependencyInjection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class City {

    //mengunakan fields(tidak direkomendasikan)

    @Getter
    @Autowired//otomatis di inject oleh spring
    private Country country;
}
