package spring_web_mvc_test.ServletResponseRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
@Controller
public class ResponseRequestController {

    @RequestMapping("/reqres")
    public void requestResponse (HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        if (name == null){
            name = "guest";
        }
        response.getWriter().println("hello "+name);
    }

}
