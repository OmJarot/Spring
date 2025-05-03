package spring_restful_api_test.spring_restful_api_test;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring_restful_api_test.spring_restful_api_test.Resolver.UserArgumentResolver;

import java.util.List;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private UserArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
        resolvers.add(userArgumentResolver);
    }
}
