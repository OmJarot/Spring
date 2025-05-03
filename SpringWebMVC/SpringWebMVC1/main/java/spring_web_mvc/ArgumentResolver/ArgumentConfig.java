package spring_web_mvc.ArgumentResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Component
public class ArgumentConfig implements WebMvcConfigurer {

    @Autowired
    PartnerArgumentResolver partnerArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }
}
