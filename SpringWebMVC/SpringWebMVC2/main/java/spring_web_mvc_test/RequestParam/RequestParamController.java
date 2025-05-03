package spring_web_mvc_test.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_web_mvc_test.Service.HelloService;

import java.io.IOException;

@Controller
public class RequestParamController {

    @Autowired
    HelloService helloService;

    @GetMapping(path = "/param")
    public void requestParam(@RequestParam(name = "name", required = false) String name,
                             HttpServletResponse response) throws IOException {
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }

}
