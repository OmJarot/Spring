package spring_web_mvc.Interceptor;

import Model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    //interceptor seperti filter

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {//akan dijalankan sebelum bean dibuat
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");//ambil sessionnya

        if (user == null){
            response.sendRedirect("/login/session");
            return false;//false artinya akan berhenti disitu
        }
        return true;//true artinya bisa di lanjutkan ke controller atau interception berikutnya
    }
}
