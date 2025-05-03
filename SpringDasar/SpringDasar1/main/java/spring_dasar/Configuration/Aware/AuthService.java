package spring_dasar.Configuration.Aware;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements ApplicationContextAware, BeanNameAware {
    //ApplicationContex untuk mendapatkan application contextnya
    //BeanNameAware untuk mendapatkan Nama beannya

    @Getter
    private String nameBean;
    @Getter
    private ApplicationContext context;

    @Override
    public void setBeanName(String name) {
        this.nameBean = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
