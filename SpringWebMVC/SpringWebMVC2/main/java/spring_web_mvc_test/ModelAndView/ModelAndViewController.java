package spring_web_mvc_test.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ModelAndViewController {

    @GetMapping(path = "/mustache")
    public ModelAndView mustache(@RequestParam (name = "name", required = false) String name){
        return new ModelAndView("hello", Map.of(
                "title","mustache",
                "name",name
        ));
    }

}
