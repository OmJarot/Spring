package spring_web_mvc_test.PathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableController {

    @GetMapping(path = "/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(@PathVariable(name = "orderId") String orderId, @PathVariable(name = "productId")String productId){
        return"OrderId: "+orderId+", ProductId: "+productId;
    }

}
