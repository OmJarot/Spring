package spring_web_mvc_test.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_web_mvc_test.Service.HelloService;

import java.io.IOException;

@Controller
public class ReqMethodController {

    @Autowired
    HelloService helloService;

    @RequestMapping(path = "/req", method = RequestMethod.GET)
//    @GetMapping(path = "req")
    public void met(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }

}
