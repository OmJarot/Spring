package spring_web_mvc.ServletIntegration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/hello")
public class HelloServlet extends HttpServlet {
//jika menggunakan web servlet harus mengregistrasikan nya di springbootaplication
    //menggunakan ServletComponentScan
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello from servlet");
    }
}
