package spring_web_mvc_test.TipeDataConverter.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ConverterController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    @GetMapping("/date")
    public void converter(@RequestParam(name = "date", required = false) Date date, //otomatis mencari converter dari string ke date
                          HttpServletResponse response) throws IOException {
        response.getWriter().println("date: "+ format.format(date));
    }

}
