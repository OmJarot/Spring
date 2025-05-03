package spring_dasar.Configuration.Component.ComponentDependencyInjection.SetterComponentDependecyInjection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Product {
    //menggunakan setter sebagai dependency injection

    @Getter
    private Brand brand;

    @Autowired//otomatis akan diinject oleh beannya
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
