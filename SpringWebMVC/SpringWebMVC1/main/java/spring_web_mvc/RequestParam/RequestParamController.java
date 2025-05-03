package spring_web_mvc.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_web_mvc.Service.HelloService;

import java.io.IOException;

@Controller
public class RequestParamController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/param")
    public void requestParam(@RequestParam(name = "name", required = false) String name, //otomatis mengirim parameter name ke string name, required bersifat tidak wajib
                             HttpServletResponse response) throws IOException {
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }
}
