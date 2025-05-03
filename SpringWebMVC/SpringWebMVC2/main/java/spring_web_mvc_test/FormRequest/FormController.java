package spring_web_mvc_test.FormRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/forms", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String form(@RequestParam(name = "name") String name,
                       @RequestParam(name = "birthDate") Date birthDate,
                       @RequestParam(name = "address") String address){
        return "Success create person with name: "+ name +
                ", birthDate: " + dateFormat.format(birthDate) +
                ", address: " + address;
    }

}
