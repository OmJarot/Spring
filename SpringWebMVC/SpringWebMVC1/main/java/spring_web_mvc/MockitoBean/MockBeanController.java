package spring_web_mvc.MockitoBean;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_web_mvc.Service.HelloService;

import java.io.IOException;

@Controller
public class MockBeanController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/mock")
    public void mockBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }

}
