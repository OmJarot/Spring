package spring_web_mvc.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ModelAndViewController {

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name){
        return new ModelAndView("hello", Map.of(//hello adalah nama filenya
                "title","Belajar view",//isi tamplatenya
                "name", name
        ));
    }

}
