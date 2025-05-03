package spring_web_mvc.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_web_mvc.Service.HelloService;

import java.io.IOException;

@Controller
public class ReqController {
    //secara default request mapping dapat menggunakan semua request method
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/req", method = RequestMethod.GET)//set hanya bisa menggunakan request method get, jika diluar get akan mengmbalikan 405 method not allowed
    //atau
    //@GetMapping("/req")
    public void reqMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String hello = helloService.hello(name);
        response.getWriter().println(hello);
    }

//    GET: @GetMapping
//    POST: @PostMapping
//    PUT: @PutMapping
//    PATCH: @PatchMapping
//    DELETE: @DeleteMapping


}
