package spring_web_mvc_test.MockitoBean;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_web_mvc_test.Service.HelloService;

import java.io.IOException;

@Controller
public class MockitoController {
    @Autowired
    HelloService helloService;

    @RequestMapping(path = "/mock")
    public void mock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }
}
