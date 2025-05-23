package spring_web_mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller//otomatis menjadi bean
public class HelloController {

    //controller handler
    @RequestMapping("/hello")//pathnya (localhost:8080/hello)
    public void helloWorld(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello World");
    }
}
