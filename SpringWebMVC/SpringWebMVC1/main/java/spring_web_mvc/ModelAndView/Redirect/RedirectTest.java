package spring_web_mvc.ModelAndView.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

@Controller
public class RedirectTest {

    @GetMapping(path = "/web/redirect")
    public ModelAndView redirect(@RequestParam(name = "name", required = false) String name){
        if (Objects.isNull(name)){//jika name nya null
            return new ModelAndView("redirect:/web/redirect?name=guest");//otomatis akan redirect
        }
        return new ModelAndView("hello", Map.of(//hello adalah nama filenya
                "title","Belajar view",//isi tamplatenya
                "name", name));
    }

}
