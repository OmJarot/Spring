package spring_web_mvc.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfigs implements WebMvcConfigurer {
    //mendaftarkan interceptor

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//addInterceptor akan di jalankan sebelum bean dibuat
        registry.addInterceptor(sessionInterceptor)//registrasi interceptor
                .addPathPatterns("/user/*");//set di path mana saja
        //cth: /user/test, /user/das, /user/dakf
        // /user/test/test X tidak akan masuk
        //agar masuk gunakan /user/** , dia akan cek ke folder dalamnya
    }
}
