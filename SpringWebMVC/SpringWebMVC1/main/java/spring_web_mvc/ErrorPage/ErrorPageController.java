package spring_web_mvc.ErrorPage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {
//untuk menghandle error yang tidak bisa di handle errorHandler

    @RequestMapping("/error")
    public ResponseEntity<String> error(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);//mengambil error status
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);//mengambil message

        String html = """
                <html>
                <body>
                <h1>$status - $message</h1>
                </body>
                </html>
                """.replace("$status", status.toString()).replace("$message", message);

        return ResponseEntity.status(status).body(html);
    }

}
