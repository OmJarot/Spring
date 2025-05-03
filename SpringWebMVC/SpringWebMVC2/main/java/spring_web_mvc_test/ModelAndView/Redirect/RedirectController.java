package spring_web_mvc_test.ModelAndView.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public ModelAndView redirect(@RequestParam(name = "piter", required = false) String name){
        if (name == null){
            return new ModelAndView("redirect:/web/redirect?name=guest");
        }
        return new ModelAndView("hello", Map.of(
                "title","Belajar view",
                "name", name));
    }

}
