package spring_web_mvc.ArgumentResolver;

import Model.Partner;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {
    //mengisi parameter di controller secara otomatis
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Partner.class);//kalo di controller method objectnya adalah parter maka akan diisi
    }

    @Override//cara mengisinya
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String apiKey = servletRequest.getHeader("X-API-KEY");

        if (apiKey != null){
            return new Partner(apiKey, "Sample Key");
        }
        throw new RuntimeException("Unauthorized Exception");
    }

}
