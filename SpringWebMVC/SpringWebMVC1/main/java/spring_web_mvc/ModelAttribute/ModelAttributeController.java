package spring_web_mvc.ModelAttribute;

import Model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ModelAttributeController {

    @PostMapping(value = "/model", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String model(@ModelAttribute CreatePersonRequest request){//otomatis binding ke fields yang ada
        System.out.println(request);
        return new StringBuilder().append("Success create person ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(" ")
                .append("With email ").append(request.getEmail()).append(" ")
                .append("With phone ").append(request.getPhone()).append(" ")
                .append("With address : ")
                .append(request.getAddress().getStreet()).append(", ")
                .append(request.getAddress().getCity()).append(", ")
                .append(request.getAddress().getCountry()).append(", ")
                .append(request.getAddress().getPostalCode())
                .toString();

    }
}
