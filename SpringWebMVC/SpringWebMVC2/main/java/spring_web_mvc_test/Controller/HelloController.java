package spring_web_mvc_test.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public void hello(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello World");
    }

}
