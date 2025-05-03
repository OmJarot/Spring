package spring_web_mvc.ServletRequestResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class RequestResponse {

    @RequestMapping("/reqresp")
    public void requestResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (name == null){
            name = "guest";
        }
        response.getWriter().println("Hello "+ name);
    }

}
